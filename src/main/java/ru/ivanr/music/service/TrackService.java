package ru.ivanr.music.service;

import org.springframework.stereotype.Service;
import ru.ivanr.music.repository.TrackRepository;
import java.util.List;
import ru.ivanr.music.entity.Track;
import java.util.Optional;

@Service
public class TrackService {
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAll() {
        return trackRepository.findAll();
    }

    public Optional<Track> getById(Long id) {
        if (id == null) {
            throw new RuntimeException("id is null");
        }
        
        return trackRepository.findById(id);
    }

    public Track create(Track track) {
        if (track == null) {
            throw new RuntimeException("Track doesnt exists");
        }  

        return trackRepository.create(track);
    }

    public Track update(Track track, Long id) {
        if (track == null) {
            throw new RuntimeException("Track is null");
        }

        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        int isUpdated = trackRepository.update(track, id);

        if (isUpdated == 0) {
            throw new RuntimeException("Track with id" + id + "doesnt exist");
        }

        return trackRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Track doesnt exist"));

    }

    public void delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }
        
        Track track = trackRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Track not found"));

        int isDeleted = trackRepository.delete(track);

        if (isDeleted == 0) {
            throw new RuntimeException("Track doesnt exist");
        }
    }
}
