package bg.tusofia.vlp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@Slf4j
public class VlpApplication {
    public static void main(String[] args) {
        SpringApplication.run(VlpApplication.class, args);
    }
}
