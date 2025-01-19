package University.UniversitySources.config;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initFirebase() {
        try {
            // Load the Firebase service account key file
            String serviceAccountKeyPath = "C:\\Users\\Thanh\\OneDrive\\Documents\\Coding\\CodingResources\\Firebase\\UniversityKeys\\university-management-sy-ac30a-firebase-adminsdk-fbsvc-38ec16f5d2.json";
            FileInputStream serviceAccount = new FileInputStream(serviceAccountKeyPath);

            // Initialize Firebase options
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://university-management-sy-ac30a-default-rtdb.firebaseio.com")
                    .build();

            // Initialize Firebase App
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Firebase", e);
        }
    }
}