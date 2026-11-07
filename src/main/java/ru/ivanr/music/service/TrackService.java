package ru.ivanr.music.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ru.ivanr.music.repository.AlbumRepository;
import ru.ivanr.music.repository.GenreRepository;
import ru.ivanr.music.repository.TrackRepository;
import java.util.List;
import ru.ivanr.music.entity.*;

import ru.ivanr.music.dto.TrackDto;

import ru.ivanr.music.mapper.*;

import java.util.stream.Collectors;

import java.util.Set;
import java.util.HashSet;


@Service
public class TrackService {
    private final TrackRepository trackRepository;

    private final AlbumRepository albumRepository;

    private final TrackMapper mapper;

    private final GenreRepository genreRepository;

    public TrackService(TrackRepository trackRepository, TrackMapper mapper, 
        AlbumRepository albumRepository, GenreRepository genreRepository) {
        this.trackRepository = trackRepository;
        this.mapper = mapper;
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
    }

    public List<TrackDto> getAll() {
        return trackRepository.findAll()
        .stream()
        .map(mapper::fromEntity)
        .collect(Collectors.toList());
    }

    public TrackDto getById(Long id) {
        if (id == null) {
            throw new RuntimeException("id is null");
        }

        Track track = trackRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Track not found"));

        return mapper.fromEntity(track);
    }

    public TrackDto create(TrackDto dto) {
        if (dto == null) {
            throw new RuntimeException("Track doesnt exists");
        }  

        Album album = albumRepository.findById(dto.getAlbumId()).orElseThrow(() 
        -> new RuntimeException("Album not found")
    );

        Set<Genre> genres = new HashSet<>();

        if (dto.getGenreIds() != null) {
            for (Long id : dto.getGenreIds()) {
                Genre genre = genreRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Genre not found with id: " + id));

                genres.add(genre);
            }
        }

        Track track = mapper.toEntity(dto, album, genres);

        Track savedTrack = trackRepository.create(track);

        return mapper.fromEntity(savedTrack);
    }


    @Transactional 
    public TrackDto update(TrackDto dto, Long id) {
        if (dto == null) {
            throw new RuntimeException("Track is null");
        }

        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        Track track = trackRepository.findById(id).orElseThrow(()
        -> new RuntimeException("Track not found")
    );

        Album album = albumRepository.findById(dto.getAlbumId()).orElseThrow(()
        -> new RuntimeException("Album not found")
    );

        Set<Genre> genres = new HashSet<>();

        if (dto.getGenreIds() != null) {
            for (Long gId : dto.getGenreIds()) {
                Genre genre = genreRepository.findById(gId)
                    .orElseThrow(() -> new RuntimeException("Genre not found with id: " + gId));

                genres.add(genre);
            }
        }

        track.setName(dto.getName());
        track.setDuration(dto.getDuration());
        track.setAlbum(album);

        track.getGenres().clear();
        track.getGenres().addAll(genres);
        
        int isUpdated = trackRepository.update(track, id);

        if (isUpdated == 0) {
            throw new RuntimeException("Track with id " + id + " doesnt exist");
        }

        return mapper.fromEntity(track);

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
