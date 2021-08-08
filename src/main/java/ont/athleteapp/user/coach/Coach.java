package ont.athleteapp.user.coach;

import ont.athleteapp.user.User;

import javax.persistence.*;

@Entity
@Table
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coach_sequence")
    @SequenceGenerator(name = "coach_sequence", sequenceName = "coach_sequence", allocationSize = 1)
    @Column(updatable = false)
    private Long id;
    private String events;
    private String degree;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Coach(){

    }

    public Coach(Long id, String events, String degree) {
        this.id = id;
        this.events = events;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", events='" + events + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
