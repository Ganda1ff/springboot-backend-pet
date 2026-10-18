package ru.ivanr.music.controller;

import org.springframework.web.bind.annotation.*;
import ru.ivanr.music.service.TrackService;
import ru.ivanr.music.entity.Track;
import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping(BaseUrl.API + TrackController.URL)
public class TrackController {
    public static final String URL = "/tracks";

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping 
    public List<Track> getAll() {
        return trackService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Track> getById(@PathVariable Long id) {
        return trackService.getById(id);
    }

    @PostMapping 
    public Track create(@RequestBody Track track) {
        return trackService.create(track);
    }

    @PutMapping("/{id}")
    public Track update(@PathVariable Long id, @RequestBody Track track) {
        return trackService.update(track, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trackService.delete(id);
    }

}
