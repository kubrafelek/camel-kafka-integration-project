package apache.camel.integration.process;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String message = exchange.getIn().getBody(String.class);

        if(!message.isEmpty()) {
            log.info("Received message: " + message);
            exchange.getMessage().setBody("Hello " + message);
        }else {
            log.info("Empty message");
            exchange.getMessage().setBody("Empty message");
        }
    }
}
