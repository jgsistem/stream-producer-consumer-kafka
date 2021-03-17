package com.stream.consumer.stream.web.controller;

import com.stream.consumer.stream.domain.dto.Bid;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class StreamController {

  @Autowired
  private StreamBridge streamBridge;

  @PostMapping
  public Bid sendMessage(@RequestBody Bid bid) {
    bid.setDate(new Date());
    streamBridge.send("new-output", bid);
    return bid;
  }
}
