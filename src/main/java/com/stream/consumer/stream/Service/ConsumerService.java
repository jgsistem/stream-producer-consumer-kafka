package com.stream.consumer.stream.Service;

import com.stream.consumer.stream.domain.dto.Bid;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.function.Consumer;
@Service
public class ConsumerService {

  @Bean
  public Consumer<Bid> bidConsumer(){
    return (input) ->{
      System.out.println("bidConsumer");
      System.out.println(input.toString());
    };
  }
}
