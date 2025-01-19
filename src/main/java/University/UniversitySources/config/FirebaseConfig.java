package University.UniversitySources.config;

<<<<<<< HEAD
import java.io.FileInputStream;
=======
import java.io.InputStream;
>>>>>>> 7ce0585e977322848117365d1ec414e1483fecee

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
<<<<<<< HEAD
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
=======
            // Load the service account key JSON file from the classpath
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("firebase-adminsdk.json");

            if (serviceAccount == null) {
                throw new RuntimeException("Failed to load Firebase service account key file.");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            // Initialize the Firebase app
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase app initialized successfully.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize Firebase", e);
        }
    }
}
>>>>>>> 7ce0585e977322848117365d1ec414e1483fecee
