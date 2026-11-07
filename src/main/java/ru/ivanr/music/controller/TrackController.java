package ru.ivanr.music.controller;

import org.springframework.web.bind.annotation.*;
import ru.ivanr.music.service.TrackService;
import ru.ivanr.music.dto.TrackDto;
import java.util.List;
import jakarta.validation.Valid;


@RestController 
@RequestMapping(BaseUrl.API + TrackController.URL)
public class TrackController {
    public static final String URL = "/tracks";

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping 
    public List<TrackDto> getAll() {
        return trackService.getAll();
    }

    @GetMapping("/{id}")
    public TrackDto getById(@PathVariable Long id) {
        return trackService.getById(id);
    }

    @PostMapping 
    public TrackDto create(@Valid @RequestBody TrackDto dto) {
        return trackService.create(dto);
    }

    @PutMapping("/{id}")
    public TrackDto update(@PathVariable Long id, @Valid @RequestBody TrackDto dto) {
        return trackService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trackService.delete(id);
    }

}
