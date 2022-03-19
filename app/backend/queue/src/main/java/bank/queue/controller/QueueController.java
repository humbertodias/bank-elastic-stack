package bank.queue.controller;

import bank.queue.mq.QueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {

  @Autowired
  private QueueProducer queueProducer;

  @GetMapping(path="enqueue/{msg}")
  public ResponseEntity<?> enqueue(@PathVariable String msg)  {
    queueProducer.send(msg);
    return ResponseEntity.ok().build();
  }

}
