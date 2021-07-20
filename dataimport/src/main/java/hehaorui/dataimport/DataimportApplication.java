package hehaorui.dataimport;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DataimportApplication {
    private static final Logger log = LoggerFactory.getLogger(DataimportApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DataimportApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(VideoRepository repo){
        return args -> {
            log.info("All of the videos");
            log.info("--------------------------");
            for(Video v:repo.findAll()){
                log.info(v.toString());
            }
            log.info("--------------------------");
            log.info("END OF LIST");
        };
    }


}
