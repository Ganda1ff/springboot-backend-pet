package ru.ivanr.music.mapper;

import ru.ivanr.music.dto.*;
import ru.ivanr.music.entity.*;
import org.springframework.stereotype.*;

import java.util.Set;

@Component
public class TrackMapper {

    public TrackDto fromEntity (Track track) {
        TrackDto dto = new TrackDto();

        dto.setId(track.getId());
        dto.setName(track.getName());
        dto.setDuration(track.getDuration());

        if (track.getAlbum() != null) {
            dto.setAlbumId(track.getAlbum().getId());
        }

        if (track.getGenres() != null) {
            dto.setGenreIds(track.getGenres().stream().map(genre -> genre.getId()).toList());
            dto.setGenreNames(track.getGenres().stream().map(Genre::getName).toList());
        }

        return dto;
    }

    public Track toEntity (TrackDto dto, Album album, Set<Genre> genres) {
        Track track = new Track();

        track.setName(dto.getName());
        track.setDuration(dto.getDuration());
        track.setAlbum(album);

        track.setGenres(genres);

        return track;
    }
}
