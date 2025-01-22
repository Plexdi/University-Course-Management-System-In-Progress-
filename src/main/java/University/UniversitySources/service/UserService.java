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
//---------------------------------------------------------------------------------------------------------
    // public void deleteUser(String userId){
    //     ApiFuture<Void> future = databaseReference.child(userId).removeValue();
    //     try {
    //         future.get();
    //         System.out.println("User Deleted Successfully");
    //     } catch (Exception e) {
    //         System.out.println("An error occurred: " + e.getMessage());
    //     }
    // }
//---------------------------------------------------------------------------------------------------------
    //this get user method is an asynchronous method, which means that it will not wait for the data to be retrieved from the database. 
    //The reason this is an asynchronous method because we are unsure how long it will take for the data to be retrieved from the database.
    //Therefore, we need to use a callback method to handle the data when it is retrieved from the database.

    public void getUser(String userId, UserCallBack userCallBack){
        databaseReference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){ //dataSnapshot is similar to a pointer that is currently pointing to the data in the database
                if(dataSnapshot.exists()){ //the "pointer" is currently pointing to a data and check whehter the data exists or not 
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
