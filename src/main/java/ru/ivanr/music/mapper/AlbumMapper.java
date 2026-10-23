package ru.ivanr.music.mapper;

import org.springframework.stereotype.Component;
import ru.ivanr.music.entity.*;
import ru.ivanr.music.dto.*;

@Component 
public class AlbumMapper {

    public Album toEntity(AlbumDto dto, Artist artist) {
        Album album = new Album();

        album.setName(dto.getName());
        album.setReleaseDate(dto.getReleaseDate());
        album.setArtist(artist);
        
        return album;
    }

    public AlbumDto fromEntity(Album album) {
        AlbumDto dto = new AlbumDto();

        dto.setId(album.getId());
        dto.setName(album.getName());
        dto.setReleaseDate(album.getReleaseDate());

        if (album.getArtist() != null) {
            dto.setArtistId(album.getArtist().getId());
            dto.setArtistName(album.getArtist().getName());
        }

        return dto;
    }
}
