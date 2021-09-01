package ont.athleteapp.training;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ont.athleteapp.training.endurance.EnduranceTraining;
import ont.athleteapp.training.endurance.EnduranceTrainingRepository;
import ont.athleteapp.training.speed.SpeedTraining;
import ont.athleteapp.training.speed.SpeedTrainingRepository;
import ont.athleteapp.training.strength.StrengthTraining;
import ont.athleteapp.training.strength.StrengthTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final SpeedTrainingRepository speedTrainingRepository;
    private final StrengthTrainingRepository strengthTrainingRepository;
    private final EnduranceTrainingRepository enduranceTrainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository, SpeedTrainingRepository speedTrainingRepository, StrengthTrainingRepository strengthTrainingRepository, EnduranceTrainingRepository enduranceTrainingRepository) {
        this.trainingRepository = trainingRepository;
        this.speedTrainingRepository = speedTrainingRepository;
        this.strengthTrainingRepository = strengthTrainingRepository;
        this.enduranceTrainingRepository = enduranceTrainingRepository;

    }

    public List<Training> getTrainings() {
        return trainingRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    public List<Training> getTrainingsByDay(LocalDate date){
        return trainingRepository.findByDate(date);
    }

    public void addTraining(ObjectNode json){
        JsonNode trainingInfo = json.get("info");
        JsonNode trainingData = json.get("data");

        LocalDate date = LocalDate.parse(trainingInfo.get("date").asText());
        LocalTime time = LocalTime.parse(trainingInfo.get("time").asText());
        String trainingType = trainingInfo.get("trainingType").asText();
        Long duration = trainingInfo.get("duration").asLong();
        Long strain = trainingInfo.get("strain").asLong();
        Long feeling = trainingInfo.get("feeling").asLong();

        Training training = new Training(date, time, trainingType, duration, strain, feeling);

        if(trainingType.equals("speed")){
            String blocks = trainingData.get("blocks").asText();
            String subMax = trainingData.get("subMax").asText();
            String maxSpeed = trainingData.get("maxSpeed").asText();
            String assistedSpeed = trainingData.get("assistedSpeed").asText();
            String comments = trainingData.get("comments").asText();

            SpeedTraining speedTraining = new SpeedTraining(blocks, subMax, maxSpeed, assistedSpeed, comments, training);
            speedTrainingRepository.save(speedTraining);
        }
        if(trainingType.equals("power")){
            String squat = trainingData.get("squat").asText();
            String powerClean = trainingData.get("powerClean").asText();
            String powerSnatch = trainingData.get("powerSnatch").asText();
            String barbellJerk = trainingData.get("barbellJerk").asText();
            String deadlift = trainingData.get("deadlift").asText();
            String straightLegDeadlift = trainingData.get("straightLegDeadlift").asText();
            String comments = trainingData.get("comments").asText();

            StrengthTraining strengthTraining = new StrengthTraining(squat, powerClean, powerSnatch, barbellJerk,deadlift,straightLegDeadlift, comments, training);
            strengthTrainingRepository.save(strengthTraining);
        }

        if(trainingType.equals("endurance")){
            String tempoRuns = trainingData.get("tempoRuns").asText();
            String jogging = trainingData.get("jogging").asText();
            String comments = trainingData.get("comments").asText();

            EnduranceTraining enduranceTraining = new EnduranceTraining(tempoRuns, jogging, comments, training);
            enduranceTrainingRepository.save(enduranceTraining);
        }

    }

    public void deleteTraining(Long trainingId){
        System.out.println(trainingId);
        boolean exists = trainingRepository.existsById(trainingId);
        if(!exists){
            throw new IllegalStateException("Training with id " + trainingId + " does not exists");
        }
        trainingRepository.deleteById(trainingId);
    }

    @Transactional
    public void updateTraining(Long id, LocalDate date, LocalTime time, String trainingType, Long duration, Long strain, Long feeling){
        Training training = trainingRepository.findById(id).orElseThrow(() -> new IllegalStateException("Training with id " + id + " does not exist"));

        if(date != null){
            training.setDate(date);
        }
        if(time != null){
            training.setTime(time);
        }
        if(trainingType != null){
            training.setTrainingType(trainingType);
        }
        if(duration != null && duration > 0 && duration < 720){
            training.setDuration(duration);
        }
        if(strain != null && strain >= 0 && strain <= 10){
            training.setStrain(strain);
        }
        if(feeling != null && feeling >= 0 && feeling <= 10){
            training.setFeeling(feeling);
        }


    }


}
