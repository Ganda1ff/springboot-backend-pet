package ru.ivanr.music.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import ru.ivanr.music.service.AlbumService;
import jakarta.validation.Valid;
import ru.ivanr.music.dto.*;

@RestController 
@RequestMapping(BaseUrl.API + AlbumController.URL)
public class AlbumController {
    public static final String URL = "/albums";

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping 
    public List<AlbumDto> getAll() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    public AlbumDto getById(@PathVariable Long id) {
        return albumService.getById(id);
    }

    @PostMapping
    public AlbumDto create(@Valid @RequestBody AlbumDto dto) {
        return albumService.create(dto);
    }

    @PutMapping("/{id}")
    public AlbumDto update(@Valid @RequestBody AlbumDto dto, @PathVariable Long id) {
        return albumService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        albumService.delete(id);

        return "Album with id: " + id + "was deleted";
    }
}