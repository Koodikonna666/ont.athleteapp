package ont.athleteapp.training.endurance;

import ont.athleteapp.training.Training;

import javax.persistence.*;

@Entity
@Table(name = "endurance_training")
public class EnduranceTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "strength_training_sequence")
    @SequenceGenerator(name = "strength_training_sequence", sequenceName = "strength_training_sequence", allocationSize=1)
    @Column(updatable = false)
    private Long id;
    @Column(name = "tempo_runs")
    private String tempoRuns;
    @Column(name = "jogging")
    private String jogging;
    @Column(name = "comments")
    private String comments;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    public EnduranceTraining(){

    }

    public EnduranceTraining(String tempoRuns, String jogging, String comments, Training training) {
        this.tempoRuns = tempoRuns;
        this.jogging = jogging;
        this.comments = comments;
        this.training = training;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTempoRuns() {
        return tempoRuns;
    }

    public void setTempoRuns(String tempoRuns) {
        this.tempoRuns = tempoRuns;
    }

    public String getJogging() {
        return jogging;
    }

    public void setJogging(String jogging) {
        this.jogging = jogging;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "EnduranceTraining{" +
                "id=" + id +
                ", tempoRuns='" + tempoRuns + '\'' +
                ", jogging='" + jogging + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
