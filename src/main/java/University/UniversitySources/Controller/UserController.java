package University.UniversitySources.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import University.UniversitySources.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/{userId}")
    public void saveUser(@PathVariable String userID, @RequestBody Object user){
        userService.saveUser(userID, user);
    }

    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }
}
