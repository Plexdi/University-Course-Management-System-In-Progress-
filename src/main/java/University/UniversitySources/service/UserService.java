package University.UniversitySources.service;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


@Service
public class UserService {
    
    private final DatabaseReference databaseReference;

    // Constructor for UserService
    public UserService(){
        this.databaseReference = FirebaseDatabase.getInstance().getReference("users");
    }

    // Method to save user
    public void saveUser(String userId, Object user) {
        databaseReference.child(userId).setValueAsync(user);
    }

    public void deleteUser(String userId){
        databaseReference.child(userId).removeValueAsync();
    }

    public void getUser(String userId, UserCallBack userCallBack){
        databaseReference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                if(dataSnapshot.exists()){
                    userCallBack.onUserCallBack(dataSnapshot.getValue());
                } else {
                    userCallBack.onUserCallBack(null);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                userCallBack.onFailure(databaseError.getMessage());
            }
        });
    }

    public interface UserCallBack {
        void onUserCallBack(Object user);
        void onFailure(String error);
    }

}
