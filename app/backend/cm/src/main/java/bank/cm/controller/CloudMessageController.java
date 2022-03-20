package bank.cm.controller;

import bank.cm.model.Note;
import bank.cm.service.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.TopicManagementResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class CloudMessageController {

    final
    FirebaseMessagingService firebaseService;

    public CloudMessageController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/subscribe-topic/{topic}")
    @ResponseBody
    public TopicManagementResponse subscribeToTopic(@PathVariable String topic, @RequestBody String ... tokens) throws FirebaseMessagingException {
        return firebaseService.subscribeToTopic(topic, tokens);
    }

    @PostMapping("/send-notification-topic/{topic}")
    @ResponseBody
    public String sendNotificationTopic(@RequestBody Note note,
                                        @PathVariable String topic) throws FirebaseMessagingException {
        return firebaseService.sendNotificationTopic(note, topic);
    }

    @PostMapping("/send-notification-token/{token}")
    @ResponseBody
    public String sendNotificationToken(@RequestBody Note note,
                                        @PathVariable String token) throws FirebaseMessagingException {
        return firebaseService.sendNotificationToken(note, token);
    }

}
