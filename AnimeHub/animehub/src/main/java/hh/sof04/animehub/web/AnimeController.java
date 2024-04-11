package hh.sof04.animehub.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof04.animehub.domain.CategoryRepository;
import hh.sof04.animehub.domain.Anime;
import hh.sof04.animehub.domain.AnimeRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AnimeController {
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/index")
    public String GetIndex(Model model) {
        model.addAttribute("animes", animeRepository.findAll());
        return "index";
    }

    @GetMapping("animelist")
    public String getAnimes(Model model) {
        model.addAttribute("animes", animeRepository.findAll());
        return "animelist";
    }

    @GetMapping("/addAnime")
    public String AddNewAnime(Model model) {
        model.addAttribute("anime", new Anime());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addAnime";
    }
    
    @PostMapping("/saveAnime")
    public String saveAnime(@ModelAttribute Anime anime) {
        //TODO: process POST request
        animeRepository.save(anime);
        return "redirect:/animelist";
    }

    @GetMapping("/deleteAnime/{id}")
    public String deleteAnime(@PathVariable("id") Long animeId) {
        animeRepository.deleteById(animeId);
        return "redirect:/animelist";
    }
    
    @GetMapping("/editAnime/{id}")
    public String getMethodName(@PathVariable("id") Long animeId, Model model) {
        Anime anime = animeRepository.findById(animeId).get();
        model.addAttribute("anime", anime);
        model.addAttribute("categories", categoryRepository.findAll());
        return "editAnime";
    }

}
