package University.UniversitySources.service;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@Service
public class InstructorService {
    private final DatabaseReference instructorDatabaseReference;

    public InstructorService(){
        this.instructorDatabaseReference = FirebaseDatabase.getInstance().getReference("instructors");
    }

    public void saveInstructor(String instructorId, Object instructors){
        instructorDatabaseReference.child(instructorId).setValueAsync(instructors);
    }

    public void deleteInstructor(String instructorId, UserCallBack userCallBack){
        instructorDatabaseReference.child(instructorId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override 
            public void onDataChange(DataSnapshot dataSnapshot){
                if(dataSnapshot.exists()){
                    dataSnapshot.getRef().removeValueAsync();
                } else{
                    System.out.println("Instructor does not exist");
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError){
                System.out.println("An error occurred: " + databaseError.getMessage());
            }
        });
    }

    public interface UserCallBack {
        void onUserCallBack(Object user);
        void onFailure(String error);
    }


}
