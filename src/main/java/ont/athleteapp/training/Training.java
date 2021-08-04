package ont.athleteapp.training;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Training {

    @Id
    private long id;
    private LocalDate date;
    private LocalTime time;
    @Column(name = "training_type")
    private  String trainingType;
    private int duration;
    private int strain;
    private int feeling;

    public Training(){

    }

    public Training(long id, LocalDate date, LocalTime time, String trainingType, int duration, int strain, int feeling) {
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStrain() {
        return strain;
    }

    public void setStrain(int strain) {
        this.strain = strain;
    }

    public int getFeeling() {
        return feeling;
    }

    public void setFeeling(int feeling) {
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
