package University.UniversitySources.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import University.UniversitySources.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired 
    private UserService userService;
    
    @PostMapping("/{userId}") //Postman Features: POST Request, Body, JSON
    public String saveUser(@PathVariable String userId, @RequestBody Object user){
        userService.saveUser(userId, user);
        return "User Saved Successfully";
    }

    public String deleteUser(@RequestBody String userId){
        userService.deleteUser(userId);
        return "User Deleted Successfully";
    }
}
