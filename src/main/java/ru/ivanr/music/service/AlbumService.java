package ru.ivanr.music.service;

import org.springframework.stereotype.Service;

import ru.ivanr.music.repository.AlbumRepository;
import ru.ivanr.music.entity.Album;
import java.util.List;
import java.util.stream.Collectors;
import ru.ivanr.music.entity.Artist;
import ru.ivanr.music.repository.ArtistRepository;

import ru.ivanr.music.mapper.*;
import ru.ivanr.music.dto.*;

@Service
public class AlbumService {
    
    private final AlbumRepository albumRepository;

    private final ArtistRepository artistRepository;

    private final AlbumMapper mapper;

    public AlbumService(AlbumRepository albumRepository, AlbumMapper mapper, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.mapper = mapper;
        this.artistRepository = artistRepository;
    }

    public List<AlbumDto> getAll() {
        return albumRepository.findAll()
            .stream()
            .map(mapper::fromEntity)
            .collect(Collectors.toList());
    }

    public AlbumDto getById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        Album album = albumRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Album not found"));

        return mapper.fromEntity(album);
    }

    public AlbumDto create(AlbumDto dto) {
        if (dto == null) {
            throw new RuntimeException("Album is null");
        }

        Artist artist = artistRepository.findById(dto.getArtistId());

        if (artist == null) {
            throw new RuntimeException("Artist with id " + dto.getArtistId() + " not found");
        }   

        Album album = mapper.toEntity(dto, artist);
        Album savedAlbum = albumRepository.save(album);

        return mapper.fromEntity(savedAlbum);
    }

    public AlbumDto update(Long id, AlbumDto dto) {
        if (id == null) throw new RuntimeException("Id is null");
        if (dto == null) throw new RuntimeException("DTO is null");

        Album album = albumRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Album not found"));

        Artist artist = artistRepository.findById(dto.getArtistId());

        if (artist == null) {
            throw new RuntimeException("Artist with id " + dto.getArtistId() + " not found");
        }   

        album.setName(dto.getName());
        album.setReleaseDate(dto.getReleaseDate());
        album.setArtist(artist);

        Album updatedAlbum = albumRepository.save(album);

        return mapper.fromEntity(updatedAlbum);
    }

    public void delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null(((");
        }

        albumRepository.deleteById(id);
    }
}
