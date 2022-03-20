1. Get Token

http://localhost:3005/cm.html

2. Send Notification by Token

```
TOKEN=cTJpTvsELJm44cxjU-RXwb:APA91bE-FwJ4Lct9_mCMEC7eMDpDZ5OCs_Fk9NNAXRM48Aqtn16IQe-_0iHzAn8W35RxMoIGpuPj0-ndg42DnZgHipPuhzo4paK53TH6IBOLQQ-ueeN-fo2PxtQPqQahOSQ_54N_qi6O
curl -X POST "http://localhost:3005/cm/send-notification-token/${TOKEN}" \
  -H "Content-Type: application/json" \
  -d '{
    "subject": "some subject",
    "content": "Some long content",
    "image": "https://somedomain.com/example.jpg",
    "data": {
      "key1": "Value 1",
      "key2": "Value 2",
      "key3": "Value 3",
      "key4": "Value 4"
    }
  }'
```


# Ref

* [Firebase console](https://console.firebase.google.com/u/0/project/_/settings/serviceaccounts/adminsdk)
* [spring-boot-firebase-push-notification](https://springhow.com/spring-boot-firebase-push-notification/#java-configuration-for-messaging)