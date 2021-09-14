package ont.athleteapp.user.coach;

import ont.athleteapp.user.User;

import javax.persistence.*;

@Entity
@Table(name = "coach")
public class Coach {

    @Id
    @Column(updatable = false)
    private Long id;
    private String events;
    private String degree;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Coach(){

    }

    public Coach(Long id, String events, String degree) {
        this.id = id;
        this.events = events;
        this.degree = degree;
    }

    public Coach(String events, String degree, User user) {
        this.user = user;
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
