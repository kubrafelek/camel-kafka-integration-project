package apache.camel.integration;

import apache.camel.integration.configuration.CamelConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CamelConfig.class})
public class ApacheCamelIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApacheCamelIntegrationApplication.class, args);
    }

}
