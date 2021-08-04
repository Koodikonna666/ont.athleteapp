package ont.athleteapp.training;

import ont.athleteapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    Optional<Training> findById(String email);

}
