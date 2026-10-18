package ru.ivanr.music.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import ru.ivanr.music.service.GenreService;
import ru.ivanr.music.entity.Genre;

@RestController 
@RequestMapping(BaseUrl.API + GenreController.URL)
public class GenreController {
    public static final String URL = "/genres";

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping 
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public Genre getById(@PathVariable Long id) {
        return genreService.getById(id);
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return genreService.create(genre);
    }

    @PutMapping("/{id}")
    public Genre update(@RequestBody Genre genre, @PathVariable Long id) {
        return genreService.update(genre, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genreService.deleteById(id);
    }
}
