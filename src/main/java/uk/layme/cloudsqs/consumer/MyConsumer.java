package uk.layme.cloudsqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    @SqsListener("minha-fila")
    public void listen(MyMessage message) {
        System.out.println("Message received: " + message.content());
    }
}
