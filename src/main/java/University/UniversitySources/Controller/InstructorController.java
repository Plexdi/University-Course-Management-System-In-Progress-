package University.UniversitySources.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import University.UniversitySources.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/{instructorId}")
    public String saveInstructor(@PathVariable String instructorId, Object instructor){
        instructorService.saveInstructor(instructorId, instructor);
        return "Instructor Saved Successfully";
    }

    //Pathvariables when you want to capture a value from the URL itself e.g ID 
    //Requestbody when you want to pass complex data like an entire object to be sent request body 

    @DeleteMapping("/deleteInstructor/{instructorId}")
    public DeferredResult<ResponseEntity<Object>> deleteInstructor(@PathVariable String instructorId){
        DeferredResult<ResponseEntity<Object>> deferredResult = new DeferredResult<>();
        instructorService.deleteInstructor(instructorId, new InstructorService.UserCallBack(){
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
