package bank.cm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class App {

	@Value("${FIREBASE_PROJECT_ID}")
	String firebaseProjectId;

	@Value("${FIREBASE_SERVICE_ACCOUNT_KEY}")
	String firebaseServiceAccountKey;

	@Bean
	FirebaseMessaging firebaseMessaging() throws IOException {
		InputStream fireBaseServiceAccountKeyStream = new ByteArrayInputStream(firebaseServiceAccountKey.getBytes(StandardCharsets.UTF_8));
		GoogleCredentials googleCredentials = GoogleCredentials
				.fromStream(fireBaseServiceAccountKeyStream);
		FirebaseOptions firebaseOptions = FirebaseOptions
				.builder()
				.setCredentials(googleCredentials)
				.build();
		FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, firebaseProjectId);
		return FirebaseMessaging.getInstance(app);
	}


	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
