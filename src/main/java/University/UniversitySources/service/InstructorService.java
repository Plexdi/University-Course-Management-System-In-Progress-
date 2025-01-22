package University.UniversitySources.service;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Service
public class InstructorService {
    private final DatabaseReference instructorDatabaseReference;

    public InstructorService(){
        this.instructorDatabaseReference = FirebaseDatabase.getInstance().getReference("instructors");
    }

    public void saveInstructor(String instructorID, Object instructor){
        instructorDatabaseReference.child(instructorID).setValueAsync(instructor);
    }


}
