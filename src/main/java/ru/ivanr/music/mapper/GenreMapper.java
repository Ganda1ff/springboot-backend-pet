package ru.ivanr.music.mapper;

import org.springframework.stereotype.Component;

import ru.ivanr.music.entity.Genre;
import ru.ivanr.music.dto.*;

@Component 
public class GenreMapper {

    public Genre toEntity(GenreDto dto) {
        Genre genre = new Genre();

        genre.setName(dto.getName());

        return genre;
    }

    public GenreDto fromEntity(Genre genre) {
        GenreDto dto = new GenreDto();

        dto.setId(genre.getId());
        dto.setName(genre.getName());

        return dto;
    }
}
