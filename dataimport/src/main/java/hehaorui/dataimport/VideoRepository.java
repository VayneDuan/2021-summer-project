package hehaorui.dataimport;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Long> {
    List<Video> findByUrl(String url);
    List<Video> findByPrice(Double price);
}


