package hh.sof04.animehub.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AnimeRepository extends CrudRepository<Anime, Long> {
    List<Anime> findByTitle(String title);
}
