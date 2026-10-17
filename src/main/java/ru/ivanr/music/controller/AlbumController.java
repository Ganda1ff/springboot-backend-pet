package ru.ivanr.music.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import ru.ivanr.music.entity.Album;
import ru.ivanr.music.service.AlbumService;

@RestController 
@RequestMapping(BaseUrl.API + AlbumController.URL)
public class AlbumController {
    public static final String URL = "/albums";

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping 
    public List<Album> getAll() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Album> getById(@PathVariable Long id) {
        return albumService.getById(id);
    }

    @PostMapping
    public Album create(@RequestBody Album album) {
        return albumService.create(album);
    }

    @PutMapping("/{id}")
    public Album update(@RequestBody Album album, @PathVariable Long id) {
        return albumService.update(id, album);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        albumService.delete(id);

        return "Album with id: " + id + "was deleted";
    }



}