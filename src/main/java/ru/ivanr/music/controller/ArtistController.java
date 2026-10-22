package ru.ivanr.music.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import ru.ivanr.music.service.ArtistService;
import jakarta.validation.Valid;
import ru.ivanr.music.dto.ArtistDto;

@RestController 
@RequestMapping(BaseUrl.API + ArtistController.URL)
public class ArtistController{
    public static final String URL = "/artists";

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping 
    public List<ArtistDto> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public ArtistDto getById(@PathVariable Long id) {
        return artistService.getById(id);
    }

    @PostMapping 
    public ArtistDto create(@Valid @RequestBody ArtistDto artist) {
        return artistService.create(artist);
    }

    @PutMapping("/{id}")
    public ArtistDto update(@Valid @RequestBody ArtistDto artist, @PathVariable Long id) {
        return artistService.update(id, artist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artistService.delete(id);
    }
}
