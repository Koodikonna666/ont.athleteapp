package ont.athleteapp.user;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import ont.athleteapp.user.athlete.Athlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/user")
    public Optional<User> getUser(@RequestParam("email") String email) {
        return userService.getUserWithEmail(email);
    }

    @PostMapping
    public void registerNewUser(@RequestBody ObjectNode json) { //@Requestbody hakee tiedot user olioon
        userService.addNewAthlete(json);
    }

    @DeleteMapping(path="{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path="{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestParam(required = false) String email, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, @RequestParam(required = false) String role, @RequestParam("bDay") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bDay) {
        userService.updateUser(userId, email, firstName, lastName, role, bDay);
    }


}
