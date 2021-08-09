package ont.athleteapp.user;

//Käytä java.persistence, koska esim. org.hibernate importtia käyttämällä tulevat muutokset saattavat rikkoa koodin.
import ont.athleteapp.user.athlete.Athlete;
import ont.athleteapp.user.coach.Coach;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

	//Käytä numeerisessa primary keyssä ennemmin Long kuin int koska int saattaa vaikuttaa jossain tapauksissa suorituskykyyn
	//Alla olevaa SequenceGeneratoria tulee käyttää mm. Oraclen palvelujen kanssa. Oracle ei toimi GenerationType.IDENTITY strategian kanssa
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence")
	@Column(updatable = false)
	private Long id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "role", nullable = false)
	private String role;
	@Column(name = "b_day")
	private LocalDate bDay;

	@PrimaryKeyJoinColumn
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coach_id")
	private Coach coach;

	@PrimaryKeyJoinColumn
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "athlete_id")
	private Athlete athlete;


	public User() {
		
	}
	public User( String firstName, String lastName, String email, String role, LocalDate bDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.bDay = bDay;
	}
	
	public User(Long id, String firstName, String lastName, String email, String role, LocalDate bDay) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.bDay = bDay;
	}
	
	public User (String firstName, String lastName, String email, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getbDay() {
		return bDay;
	}

	public void setbDay(LocalDate bDay) {
		this.bDay = bDay;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", role="
				+ role + "]";
	}
	
	
	
	
}
