package uk.layme.cloudsqs;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uk.layme.cloudsqs.consumer.MyMessage;

@SpringBootApplication
public class CloudSqsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CloudSqsApplication.class, args);
    }

    @Autowired
    private SqsTemplate sqsTemplate;

    @Override
    public void run(String... args) throws Exception {
        String SQS = "http://localhost:4566/000000000000/minha-fila";
        SendResult<MyMessage> result =  sqsTemplate.send(SQS, new MyMessage("meu valor de start"));
        System.out.println(result);
    }
}
