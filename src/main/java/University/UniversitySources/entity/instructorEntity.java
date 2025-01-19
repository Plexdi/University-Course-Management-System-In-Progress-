import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class instructorEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private long instructorID;
    private String name; 
    private String email;
    private String password;
    private String course;

    public long getInstructorID(){
        return instructorID;
    }

    public void setInstructorID(long Id){
        this.instructorID = Id;
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

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    
}
