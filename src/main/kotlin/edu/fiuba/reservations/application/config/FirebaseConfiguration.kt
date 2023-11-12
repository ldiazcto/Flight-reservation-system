package edu.fiuba.reservations.application.config

import com.google.api.client.util.Value
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream


@Configuration
class FirebaseConfiguration {
    @Bean
    fun firestore(): Firestore {
        val serviceAccount = FileInputStream("./src/main/resources/firebase-account-info.json")
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build()
        val firebaseApp = FirebaseApp.initializeApp(options)

        return FirestoreClient.getFirestore(firebaseApp)
    }
}
