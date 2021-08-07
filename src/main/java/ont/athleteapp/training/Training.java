package ont.athleteapp.training;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence")
    @Column(updatable = false)
    private long id;
    private LocalDate date;
    private LocalTime time;
    @Column(name = "training_type")
    private  String trainingType;
    private Long duration;
    private Long strain;
    private Long feeling;

    public Training(){

    }

    public Training(long id, LocalDate date, LocalTime time, String trainingType, Long duration, Long strain, Long feeling) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.trainingType = trainingType;
        this.duration = duration;
        this.strain = strain;
        this.feeling = feeling;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getStrain() {
        return strain;
    }

    public void setStrain(Long strain) {
        this.strain = strain;
    }

    public Long getFeeling() {
        return feeling;
    }

    public void setFeeling(Long feeling) {
        this.feeling = feeling;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", trainingType='" + trainingType + '\'' +
                ", duration=" + duration +
                ", strain=" + strain +
                ", feeling=" + feeling +
                '}';
    }
}
