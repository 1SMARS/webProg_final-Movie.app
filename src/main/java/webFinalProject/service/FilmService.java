package webFinalProject.service;

import webFinalProject.entity.Films;
import webFinalProject.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmService {

    private final FilmsRepository filmsRepository;

    @Autowired
    public FilmService(FilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

    public Films findById(Long id){
        return filmsRepository.getOne(id);
    }

    public List<Films> findAll(){
        return filmsRepository.findAll();
    }

    public void saveFilm(Films film) {
        filmsRepository.save(film);
    }

    public void deleteById(Long id){
        filmsRepository.deleteById(id);
    }
}
