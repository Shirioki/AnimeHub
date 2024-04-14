package hh.sof04.animehub.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import hh.sof04.animehub.domain.AnimeRepository;
import hh.sof04.animehub.domain.CategoryRepository;
import hh.sof04.animehub.domain.Anime;
import hh.sof04.animehub.domain.Category;

@RestController
@RequestMapping("/api")
public class RestAnimeController {

    @Autowired
    private AnimeRepository animeRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/animes")
     public Iterable<Anime> getAnimes(){
        return animeRepository.findAll();
     }

    @GetMapping("/categories")
     public Iterable<Category> getCategories(){
        return categoryRepository.findAll();
     }

}
