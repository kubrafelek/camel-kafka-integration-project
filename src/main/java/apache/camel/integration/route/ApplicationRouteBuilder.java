package apache.camel.integration.route;

import apache.camel.integration.process.KafkaProcessor;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

@Component
public class ApplicationRouteBuilder extends RouteBuilder {

    private final String toUri;
    private final String fromUri;
    private final KafkaProcessor kafkaProcessor;

    public ApplicationRouteBuilder(@Value("${kafka.integration.from}") String fromUri,
                                   @Value("${kafka.integration.to}") String toUri,
                                   KafkaProcessor kafkaProcessor) {
        this.toUri = toUri;
        this.fromUri = fromUri;
        this.kafkaProcessor = kafkaProcessor;
    }

    @Override
    public void configure() throws Exception {

        from(fromUri)
                .routeGroup("activemq-kafka-integration-group")
                .routeId("activemq-kafka-integration-route")
                .log("Started message flow from activemq into kafka")
                .setHeader(KafkaConstants.TOPIC, constant("Camel"))
                .process(kafkaProcessor)
                .to(toUri)
                .log("Finished message flow from activemq into kafka successfully");
    }

}

