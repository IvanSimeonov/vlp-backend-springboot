package bg.tusofia.vlp;

import bg.tusofia.vlp.topic.domain.Topic;
import bg.tusofia.vlp.topic.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ConfigurationPropertiesScan
public class VlpApplication {

    public static void main(String[] args) {
        SpringApplication.run(VlpApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TopicRepository topicRepository, Environment environment) {
        return args -> {
            var t = new Topic();
            t.setTitle("TOBE-DELETED");
            t.setDescription("Hello World");
            t = topicRepository.save(t);

            t.setDescription("Hellooooooooo");

            topicRepository.save(t);


            topicRepository.delete(t);
        };
    }

}
