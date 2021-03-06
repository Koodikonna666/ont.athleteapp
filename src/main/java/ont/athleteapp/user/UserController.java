package ont.athleteapp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void registerNewUser(@RequestBody User user) { //@Requestbody hakee tiedot user olioon
        userService.addNewUser(user);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteUser(@PathVariable("studentId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path="{studentId}")
    public void updateUser(@PathVariable("studentId") Long userId, @RequestParam(required = false) String email) {
        userService.updateUser(userId, email);
    }


}
