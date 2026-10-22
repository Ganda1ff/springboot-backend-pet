package ru.ivanr.music.mapper;

import ru.ivanr.music.entity.*;
import ru.ivanr.music.dto.*;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {
    
    public Artist toEntity(ArtistDto dto) {
        Artist artist = new Artist();

        artist.setName(dto.getName());
        artist.setBirthDate(dto.getBirthDate());
        artist.setBirthCountry(dto.getBirthCountry());

        return artist;
    }

    public ArtistDto fromEntity(Artist artist) {
        ArtistDto dto = new ArtistDto();

        dto.setId(artist.getId());
        dto.setName(artist.getName());
        dto.setBirthDate(artist.getBirthDate());
        dto.setBirthCountry(artist.getBirthCountry());

        return dto;
    }

}
