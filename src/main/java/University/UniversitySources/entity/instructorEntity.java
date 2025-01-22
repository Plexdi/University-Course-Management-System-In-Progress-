package University.UniversitySources.Entity;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class instructorEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @NotNull(message = "ID is required")
    private long instructorId;

    @NotNull(message = "Name is required")
    private String name; 

    @NotNull(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "Course is required")
    @ElementCollection
    private List<String> courses;

    public long getInstructorID(){
        return instructorId;
    }

    public void setInstructorID(long Id){
        this.instructorId = Id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public List<String> getCourse(){
        return courses;
    }

    public void setCourse(List<String> courses){
        this.courses = courses;
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }

    
}
