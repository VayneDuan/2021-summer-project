package hehaorui.dataimport;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class DataimportApplication {
    private static final Logger log = LoggerFactory.getLogger(DataimportApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DataimportApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(NewsRepository repo, CloudSolrClient client){
        return args -> {
//            log.info("start inserting data into solr");
//            for(News news: repo.findAll()){
//                log.info("insert item: "+news);
//                client.addBean(news);
//            }
//            client.commit();
//            log.info("insert finished");
//            log.info(client.getById("1").toString());
//            log.info("END OF INSERTION");

            log.info("try to query data from solr");
            Map<String, String> pmap = new HashMap<>();
            pmap.put("q", "newsid:[3 TO 4]");
            MapSolrParams params = new MapSolrParams(pmap);
            log.info("query content: "+params.toQueryString());
            QueryResponse response = client.query("newscollection", params);
//            SolrDocumentList documents = response.getResults();
            List<News> results = response.getBeans(News.class);
            log.info("found "+ results.size()+" news");
            for(News n : results) {
                log.info(n.toString());
            }
            log.info("query finished");


        };
    }


}
