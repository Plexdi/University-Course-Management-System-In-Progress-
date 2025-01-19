package University.UniversitySources.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class userEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private long studentId;
    private String name; 
    private String course;
    private String email;
    private String password;

    public long getStudentId(){
        return studentId;
    }

    public void setStudentId(long Id){
        this.studentId = Id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
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
}
