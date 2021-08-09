package ont.athleteapp.user;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ont.athleteapp.user.athlete.Athlete;
import ont.athleteapp.user.athlete.AthleteRepository;
import ont.athleteapp.user.coach.Coach;
import ont.athleteapp.user.coach.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Sama asia kun @Component annotaatio, mutta @Service annotaatio on semanttisempi
@Service
public class UserService {

    private final UserRepository userRepository;
    private final AthleteRepository athleteRepository;
    private final CoachRepository coachRepository;

    //@Aurowired injektoi userReposirotyn
    @Autowired
    public UserService(UserRepository userRepository, AthleteRepository athleteRepository, CoachRepository coachRepository) {
        this.userRepository = userRepository;
        this.athleteRepository = athleteRepository;
        this.coachRepository = coachRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(ObjectNode json){
//      Tallennetaan jsonista haetut tiedot oikeaan muotoon
        JsonNode uData = json.get("user");
        JsonNode iData = json.get("info");

        String firstName = uData.get("firstName").asText();
        String lastName = uData.get("lastName").asText();
        String email = uData.get("email").asText();
        String role = uData.get("role").asText();
        LocalDate bDay = LocalDate.parse(uData.get("bDay").asText());

//      Tarkistetaan onko sähköpostilla tehty jo käyttäjää
        Optional<User> userByEmail = userRepository.findUserByEmail(email);
        if(userByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        System.out.println(iData);

        User user = new User(firstName, lastName, email, role, bDay);

//      Tarkistetaan onko lisättävä käyttäjä urheilija vai valmentaja ja hoidetaan tietokantatallennus
        if(role.equals("athlete")){
            String aEvents = iData.get("events").asText();
            String club = iData.get("club").asText();
            Athlete athlete = new Athlete(aEvents, club, user);
            athleteRepository.save(athlete);
        }else if(role.equals("coach")){
            String cEvents = iData.get("events").asText();
            String degree = iData.get("degree").asText();
            Coach coach = new Coach(cEvents, degree, user);
            coachRepository.save(coach);
        }else{
            throw new IllegalStateException("Ei valmentaja eikä urjeilija");
        }

    }

    public void addNewUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        userRepository.save(user);
    }

    public Optional<User> getUserWithEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
    }

    //@Transactional annotaatio hoitaa tietokannan päivittämisen. Entity menee "manage" tilaan
    @Transactional
    public void updateUser(Long userId, String email, String firstName, String lastName, String role, LocalDate bDay) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));

            if(firstName != null){
                user.setFirstName(firstName);
            }
            if(lastName != null){
                user.setLastName(lastName);
            }
            if(role != null){
                user.setRole(role);
            }
            if(bDay != null){
                user.setbDay(bDay);
            }

        if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if(userOptional.isPresent()) {
                throw new IllegalStateException("Email already used");
            }
                user.setEmail(email);
        }
    }


}