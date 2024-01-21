package apache.camel.integration.configuration;

import org.apache.camel.component.amqp.AMQPComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CamelConfig implements WebMvcConfigurer {

    @Value("${spring.activemq.user}")
    String username;

    @Value("${spring.activemq.password}")
    String password;

    @Value("${spring.activemq.broker-url}")
    String brokerUrl;

    @Bean
    public ActiveMQC amqpConnection() {
        AMQPComponent amqp = new AMQPComponent();
        amqp.setConnectionFactory();
        return null;
    }
}
