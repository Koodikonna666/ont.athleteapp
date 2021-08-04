package ont.athleteapp.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService){
        this.trainingService = trainingService;
    }

    @GetMapping(path = "/trainings")
    public List<Training> getTrainings(){
        return trainingService.getTrainings();
    }

    @PostMapping
    public void addTraining(@RequestBody Training training) {
        trainingService.addTraining(training);
    }


}
