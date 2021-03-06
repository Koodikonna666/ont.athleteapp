package ont.athleteapp.user;

//Käytä java.persistence, koska esim. org.hibernate importtia käyttämällä tulevat muutokset saattavat rikkoa koodin.
import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(name="student_email_unique", columnNames = "email")})
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
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "role", nullable = false)
	private String role;
	
	public User() {
		
	}
	
	public User(Long id, String firstName, String lastName, String email, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", role="
				+ role + "]";
	}
	
	
	
	
}
