package ru.ivanr.music.service;

import ru.ivanr.music.repository.GenreRepository;
import ru.ivanr.music.dto.GenreDto;
import ru.ivanr.music.entity.Genre;
import org.springframework.stereotype.Service;
import java.util.List;
import ru.ivanr.music.mapper.GenreMapper;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    private final GenreMapper mapper;


    public GenreService(GenreRepository genreRepository, GenreMapper mapper) {
        this.genreRepository = genreRepository;
        this.mapper = mapper;
    }

    public List<GenreDto> getAll() {
        return genreRepository.findAll()
            .stream()
            .map(mapper::fromEntity)
            .toList();
    }

    public GenreDto getById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        Genre genre = genreRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Genre not found"));

        return mapper.fromEntity(genre);
    }

    public GenreDto create(GenreDto dto) {
        if (dto == null) {
            throw new RuntimeException("Genre doesnt exist");
        }

        Genre genre = mapper.toEntity(dto);

        Genre createdGenre = genreRepository.save(genre);

        return mapper.fromEntity(createdGenre);
    }

    public GenreDto update(GenreDto dto, Long id) {
        if (id == null) throw new RuntimeException("Id is null");
        if (dto == null) throw new RuntimeException("Genre is null");
        
        Genre genre = genreRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Genre no found"));
   
        genre.setName(dto.getName());

        Genre updatedGenre = genreRepository.save(genre);

        return mapper.fromEntity(updatedGenre);
    }

    public void deleteById(Long id) {
        if (id == null) throw new RuntimeException("Id is null");

        Genre deletedGenre = genreRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Genre no found"));

        genreRepository.delete(deletedGenre);
    }
}
