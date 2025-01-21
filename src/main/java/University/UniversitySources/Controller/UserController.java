package University.UniversitySources.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult; //DeferredResult is a class that handles asynchronous respond to the client

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

    @GetMapping("/getUser/{userId}")
    public DeferredResult<ResponseEntity<Object>> getUser(@PathVariable String userId){
        DeferredResult<ResponseEntity<Object>> deferredResult = new DeferredResult<>();
        userService.getUser(userId, new UserService.UserCallBack() {
            @Override
            public void onUserCallBack(Object user){
                if(user != null){
                    deferredResult.setResult(ResponseEntity.ok(user));
                } else {
                    deferredResult.setResult(ResponseEntity.notFound().build());
                }   
            }

            @Override
            public void onFailure(String error){
                deferredResult.setErrorResult(ResponseEntity.status(500).body("An error occurred: " + error));
            }
        });
        return deferredResult;
    }


}
