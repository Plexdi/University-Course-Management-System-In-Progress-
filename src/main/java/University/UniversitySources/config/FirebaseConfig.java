package University.UniversitySources.config;

import java.io.InputStream;

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
