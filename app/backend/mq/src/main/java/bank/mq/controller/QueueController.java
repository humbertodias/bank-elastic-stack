package bank.mq.controller;

import bank.mq.queue.QueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueueController {

  @Autowired
  private QueueProducer queueProducer;

  @GetMapping(path="enqueue/{msg}")
  public ResponseEntity<?> enqueue(@PathVariable String msg)  {
    queueProducer.send(msg);
    return ResponseEntity.ok().build();
  }

}
