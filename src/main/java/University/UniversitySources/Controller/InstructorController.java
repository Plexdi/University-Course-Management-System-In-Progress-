package University.UniversitySources.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import University.UniversitySources.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/addInstructor")
    public String saveInstructor(String instructorId, Object instructor){
        instructorService.saveInstructor(instructorId, instructor);
        return "Instructor Saved Successfully";
    }

}
