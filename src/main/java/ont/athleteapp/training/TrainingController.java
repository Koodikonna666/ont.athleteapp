package ont.athleteapp.training;


import com.fasterxml.jackson.databind.node.ObjectNode;
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

/*    Käytä @DateTimeFormat koska muuten tulee parse errori kun urlista saatava tieto on String muotoa.
     @DateTimeFormat osaa muuttaa Stringin oikeaan muotoon*/
    @GetMapping(path = "/trainings/day")
    public List<Training> getTrainingsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
       return trainingService.getTrainingsByDay(date);
    }

    @PostMapping
    public void addTraining(@RequestBody ObjectNode json) {
        trainingService.addTraining(json);
    }

    @DeleteMapping(path = "{trainingId}")
    public void deleteTraining(@PathVariable("trainingId") Long trainingId) {
        trainingService.deleteTraining(trainingId);
    }

    @PutMapping(path = "{trainingId}")
    public void updateTraining(@PathVariable("trainingId") Long trainingId){
        trainingService.updateTraining(trainingId);
    }

}
