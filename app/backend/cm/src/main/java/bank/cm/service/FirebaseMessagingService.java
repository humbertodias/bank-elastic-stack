package bank.cm.service;

import bank.cm.model.Note;
import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public TopicManagementResponse subscribeToTopic(String topic, String ... tokens) throws FirebaseMessagingException {
        // These registration tokens come from the client FCM SDKs.
        List<String> registrationTokens = Arrays.asList(tokens);

        // Subscribe the devices corresponding to the registration tokens to the topic.
        return firebaseMessaging.subscribeToTopic(registrationTokens, topic);

    }

    public String sendNotificationTopic(Note note, String topic) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .build();

        Message message = Message
                .builder()
                .setTopic(topic)
                .setNotification(notification)
                .putAllData(note.getData())
                .build();

        return firebaseMessaging.send(message);
    }

    public String sendNotificationToken(Note note, String token) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .build();

        Message message = Message
                .builder()
                .setToken(token)
                .setNotification(notification)
                .putAllData(note.getData())
                .build();

        return firebaseMessaging.send(message);
    }

}
