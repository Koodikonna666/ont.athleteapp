package ont.athleteapp.training;


import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/t")
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

    @PutMapping(path = "{trainingId}")
    public void updateTraining(@PathVariable("trainingId") Long trainingId, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time, @RequestParam(required = false) String trainingType, @RequestParam(required = false) Long duration, @RequestParam(required = false) Long strain, @RequestParam(required = false) Long feeling){
        trainingService.updateTraining(trainingId, date, time,trainingType, duration, strain, feeling);
    }

}
