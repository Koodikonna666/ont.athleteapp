package ont.athleteapp.user.athlete;

import ont.athleteapp.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "athlete")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "athlete_sequence")
    @SequenceGenerator(name = "athlete_sequence", sequenceName = "athlete_sequence")
    @Column(updatable = false)
    private Long id;
    private String events;
    private String club;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "athlete")
    private User user;

    public Athlete(){

    }

    public Athlete(Long id, String events, String club) {
        this.id = id;
        this.events = events;
        this.club = club;
    }

    public Athlete(String events, String club) {
        this.events = events;
        this.club = club;
    }

    public Athlete(String events, String club, User user) {
        this.events = events;
        this.club = club;
        this.user = user;
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

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", events=" + events +
                ", club='" + club + '\'' +
                '}';
    }
}
