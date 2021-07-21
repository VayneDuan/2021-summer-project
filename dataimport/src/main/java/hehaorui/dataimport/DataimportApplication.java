package hehaorui.dataimport;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
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
    public CommandLineRunner test(NewsRepository repo, CloudSolrClient client){
        return args -> {
            log.info("start inserting data into solr");
            for(News news: repo.findAll()){
                log.info("insert item: "+news);
                client.addBean(news);
            }
            client.commit();
            log.info("insert finished");
            log.info(client.getById("1").toString());
            log.info("END OF OPERATION");

        };
    }


}
