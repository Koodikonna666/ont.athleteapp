package ont.athleteapp.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository on vastuussa tietokannan yhteydestä(Lisää UserRepository koodiin ja pääset käsiksi tietokantaan)
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    //SELECT * FROM user WHERE email = ?
    Optional<User> findUserByEmail(String email);
}
