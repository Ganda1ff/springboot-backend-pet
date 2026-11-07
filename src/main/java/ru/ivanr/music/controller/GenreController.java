package ru.ivanr.music.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import ru.ivanr.music.service.GenreService;
import ru.ivanr.music.dto.GenreDto;
import jakarta.validation.Valid;

@RestController 
@RequestMapping(BaseUrl.API + GenreController.URL)
public class GenreController {
    public static final String URL = "/genres";

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping 
    public List<GenreDto> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public GenreDto getById(@PathVariable Long id) {
        return genreService.getById(id);
    }

    @PostMapping
    public GenreDto create(@Valid @RequestBody GenreDto dto) {
        return genreService.create(dto);
    }

    @PutMapping("/{id}")
    public GenreDto update(@Valid @RequestBody GenreDto dto, @PathVariable Long id) {
        return genreService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genreService.deleteById(id);
    }
}
