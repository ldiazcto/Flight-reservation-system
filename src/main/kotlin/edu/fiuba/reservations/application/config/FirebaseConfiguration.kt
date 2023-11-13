package edu.fiuba.reservations.application.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream

@Configuration
class FirebaseConfiguration {
    @Value("\${data.firebase.path}")
    private lateinit var firebaseAccountInfoPath: String

    @Bean
    fun firestore(): Firestore {
        val serviceAccount = FileInputStream(firebaseAccountInfoPath)
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build()
        val firebaseApp = FirebaseApp.initializeApp(options)

        return FirestoreClient.getFirestore(firebaseApp)
    }
}
