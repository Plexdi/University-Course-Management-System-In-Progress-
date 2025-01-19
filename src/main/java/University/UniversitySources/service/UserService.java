package University.UniversitySources.service;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
}
