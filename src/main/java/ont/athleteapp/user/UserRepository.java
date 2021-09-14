package ont.athleteapp.user;

import java.util.Optional;

import ont.athleteapp.training.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Repository on vastuussa tietokannan yhteydestä(Lisää repository koodiin ja pääset käsiksi tietokantaan)
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    /*  Query annotaatio antaa kirjoittaa itse omia JPQL tai natiivi kyselyitä.
    Tämä ylikirjoittaa metodin nimen, joka ilman annotaatiota osoittaa kyselyn.*/

    /*     Voit käyttää JPQL dokumentaatiosta saatavia avainsanoja (esim And Or LessThan) ja luoda omia
    kyselyjä ja luoda esim. findUserByFirstNameEqualsAndAgeIsLessThan(String name, Long age)*/

    //    @Query("SELECT s FROM User s WHERE s.email = ?1")
    Optional<User> findUserByEmail(String email);

}
