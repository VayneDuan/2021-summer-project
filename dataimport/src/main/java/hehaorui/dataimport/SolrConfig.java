package hehaorui.dataimport;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class SolrConfig {
    private List<String> zkHosts = new ArrayList<String>();
    private String defaultCollection="mycollection";

    @Bean
    public CloudSolrClient solrClient(){
        zkHosts.add("192.168.3.1:2182");
        zkHosts.add("192.168.3.1:2183");
        zkHosts.add("192.168.3.1:2184");
        CloudSolrClient client = new CloudSolrClient.Builder(zkHosts, Optional.ofNullable(null)).
                                    withConnectionTimeout(10000).
                                    withSocketTimeout(60000).build();
        client.setDefaultCollection(defaultCollection);
        return client;
    }

}
