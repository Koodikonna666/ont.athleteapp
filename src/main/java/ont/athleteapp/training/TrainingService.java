package ont.athleteapp.training;

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

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> getTrainings() {
        return trainingRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    public List<Training> getTrainingsByDay(LocalDate date){
        return trainingRepository.findByDate(date);
    }

    public void addTraining(Training training){
        trainingRepository.save(training);
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
