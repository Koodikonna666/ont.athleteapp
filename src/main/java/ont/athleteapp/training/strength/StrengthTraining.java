package ont.athleteapp.training.strength;


import ont.athleteapp.training.Training;

import javax.persistence.*;

@Entity
@Table(name = "strength_training")
public class StrengthTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "strength_training_sequence")
    @SequenceGenerator(name = "strength_training_sequence", sequenceName = "strength_training_sequence", allocationSize=1)
    @Column(updatable = false)
    private Long id;
    @Column(name = "squat")
    private String squat;
    @Column(name = "power_clean")
    private String powerClean;
    @Column(name = "power_snatch")
    private String powerSnatch;
    @Column(name = "barbell_jerk")
    private String barbellJerk;
    @Column(name = "deadlift")
    private String deadlift;
    @Column(name = "straight_leg_deadlift")
    private String straightLegDeadlift;
    @Column(name = "comments")
    private String comments;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    public StrengthTraining(){

    }

    public StrengthTraining(Long id, String squat, String powerClean, String powerSnatch, String barbellJerk, String deadlift, String straightLegDeadlift, String comments) {
        this.id = id;
        this.squat = squat;
        this.powerClean = powerClean;
        this.powerSnatch = powerSnatch;
        this.barbellJerk = barbellJerk;
        this.deadlift = deadlift;
        this.straightLegDeadlift = straightLegDeadlift;
        this.comments = comments;
    }
    public StrengthTraining(String squat, String powerClean, String powerSnatch, String barbellJerk, String deadlift, String straightLegDeadlift, String comments, Training training) {
        this.squat = squat;
        this.powerClean = powerClean;
        this.powerSnatch = powerSnatch;
        this.barbellJerk = barbellJerk;
        this.deadlift = deadlift;
        this.straightLegDeadlift = straightLegDeadlift;
        this.comments = comments;
        this.training = training;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSquat() {
        return squat;
    }

    public void setSquat(String squat) {
        this.squat = squat;
    }

    public String getPowerClean() {
        return powerClean;
    }

    public void setPowerClean(String powerClean) {
        this.powerClean = powerClean;
    }

    public String getPowerSnatch() {
        return powerSnatch;
    }

    public void setPowerSnatch(String powerSnatch) {
        this.powerSnatch = powerSnatch;
    }

    public String getBarbellJerk() {
        return barbellJerk;
    }

    public void setBarbellJerk(String barbellJerk) {
        this.barbellJerk = barbellJerk;
    }

    public String getDeadlift() {
        return deadlift;
    }

    public void setDeadlift(String deadlift) {
        this.deadlift = deadlift;
    }

    public String getStraightLegDeadlift() {
        return straightLegDeadlift;
    }

    public void setStraightLegDeadlift(String straightLegDeadlift) {
        this.straightLegDeadlift = straightLegDeadlift;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "StrengthTraining{" +
                "id=" + id +
                ", squat='" + squat + '\'' +
                ", powerClean='" + powerClean + '\'' +
                ", powerScnatch='" + powerSnatch + '\'' +
                ", barbellJerk='" + barbellJerk + '\'' +
                ", deadlift='" + deadlift + '\'' +
                ", straightLegDeadlift='" + straightLegDeadlift + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
