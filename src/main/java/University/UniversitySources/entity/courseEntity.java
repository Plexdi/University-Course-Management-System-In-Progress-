package University.UniversitySources.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class courseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private long courseId;
    private String courseName; 
    private String courseCode; 
    private char gradeRequired;

    public long getCourseId(){
        return courseId;
    }

    public void setCourseId(long Id){
        this.courseId = Id;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String name){
        this.courseName = name;
    }

    public String getCourseCode(){
        return courseCode;

    }

    public void setCourseCode(String code){
        this.courseCode = code;

    }

    public char getGradeRequirement(){
        return gradeRequired;

    }

    public void setGradeRequirement(char grade){
        this.gradeRequired = grade;
    }
}
