package ru.ivanr.music.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import ru.ivanr.music.entity.Artist;
import ru.ivanr.music.service.ArtistService;


@RestController 
@RequestMapping(BaseUrl.API + ArtistController.URL)
public class ArtistController{
    public static final String URL = "/artists";

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping 
    public List<Artist> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable Long id) {
        return artistService.getById(id);
    }

    @PostMapping 
    public Artist create(@RequestBody Artist artist) {
        return artistService.create(artist);
    }

    @PutMapping("/{id}")
    public Artist update(@RequestBody Artist artist, @PathVariable Long id) {
        return artistService.update(id, artist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artistService.delete(id);
    }
}
