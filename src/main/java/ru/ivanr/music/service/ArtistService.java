package ru.ivanr.music.service;

import ru.ivanr.music.repository.ArtistRepository;
import ru.ivanr.music.entity.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

import ru.ivanr.music.mapper.ArtistMapper;
import ru.ivanr.music.dto.ArtistDto;

import java.util.stream.Collectors;

@Service
public class ArtistService {
    
    private final ArtistRepository artistRepository;
    private final ArtistMapper mapper;

    public ArtistService(ArtistRepository artistRepository, ArtistMapper mapper) {
        this.artistRepository = artistRepository;
        this.mapper = mapper;
    }

    public List<ArtistDto> getAll() {
        return artistRepository.findAll()
            .stream()
            .map(mapper::fromEntity)
            .collect(Collectors.toList());  
    }

    public ArtistDto getById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        Artist artist = artistRepository.findById(id);

        if (artist == null) {
            throw new RuntimeException("Artist is null");
        }

        return mapper.fromEntity(artist);
    }

    public ArtistDto create(ArtistDto dto) {

        if (dto == null) {
            throw new RuntimeException("artist dto is null");
        }

        Artist artist = mapper.toEntity(dto);

        Artist savedArtist = artistRepository.save(artist);
        
        return mapper.fromEntity(savedArtist);

    }

    public ArtistDto update(Long id, ArtistDto dto) {

        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        Artist artist = artistRepository.findById(id);

        if (artist == null) {
            throw new RuntimeException("Artist is null");
        }

        artist.setName(dto.getName());
        artist.setBirthDate(dto.getBirthDate());
        artist.setBirthCountry(dto.getBirthCountry());

        Artist updatedArtist = artistRepository.save(artist);

        return mapper.fromEntity(updatedArtist);
    }

    public void delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        artistRepository.deleteById(id);
    }
    
    
}

    
