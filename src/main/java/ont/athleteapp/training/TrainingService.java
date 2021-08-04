package ont.athleteapp.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    public void addTraining(Training training){
        trainingRepository.save(training);
    }

}
