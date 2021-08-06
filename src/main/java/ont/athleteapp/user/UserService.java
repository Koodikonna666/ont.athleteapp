package ont.athleteapp.user;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Sama asia kun @Component annotaatio, mutta @Service annotaatio on semanttisempi
@Service
public class UserService {

    private final UserRepository userRepository;

    //@Aurowired injektoi userReposirotyn
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
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
    public void updateUser(Long userId, String email, String firstName, String lastName, String role) {
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

        if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if(userOptional.isPresent()) {
                throw new IllegalStateException("Email already used");
            }
                user.setEmail(email);
        }
    }


}