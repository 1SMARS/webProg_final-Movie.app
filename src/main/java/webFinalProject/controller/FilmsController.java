package webFinalProject.controller;

import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import webFinalProject.entity.Films;
import webFinalProject.repository.FilmsRepository;
import webFinalProject.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EnableSwagger2
@RestController
public class FilmsController {

    private final FilmService filmService;
    private final FilmsRepository filmsRepository;

    @Autowired
    public FilmsController(FilmService filmService, FilmsRepository filmsRepository) {
        this.filmService = filmService;
        this.filmsRepository = filmsRepository;
    }

    @GetMapping("/films")
    public String findAll(Model model){
        List<Films> films = filmService.findAll();
        model.addAttribute("films", films);
        return "film-list";
    }

    @GetMapping("/film-add")
    public String createFilmForm(Films film){
        return "film-add";
    }

    @PostMapping("/film-add")
    public String createFilm(Films film){

        filmService.saveFilm(film);
        return "redirect:/films";
    }

    @GetMapping("film-delete/{id}")
    public String deleteFilm(@PathVariable("id") Long id){
        filmService.deleteById(id);
        return "redirect:/films";
    }

    @GetMapping("/film-update/{id}")
    public String updateFilmForm(@PathVariable("id") Long id, Model model){
        Films film = filmService.findById(id);
        model.addAttribute("film", film);
        return "film-update";
    }

    @PostMapping("/film-update")
    public String updateFilm(Films film){

            filmService.saveFilm(film);
            return "redirect:/films";

    }

    @GetMapping("/film/{id}")
    public String filmInfo(@PathVariable(value = "id") Long id, Model model) {
        if(!filmsRepository.existsById(id)) {
            return"redirect:/films";
        }
        Optional<Films> film = filmsRepository.findById(id);
        ArrayList<Films> res = new ArrayList<>();
        film.ifPresent(res::add);
        model.addAttribute("film", res);
        return"films-description";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}