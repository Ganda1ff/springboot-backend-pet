package ru.ivanr.music.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class TrackDto {

    Long id; 

    @NotBlank 
    @Size(min = 1, max = 100)
    String name;

    @Positive  
    Integer duration;

    @NotNull 
    Long albumId;

    @NotNull 
    List<Long> genreIds;

    @NotNull 
    List<String> genreNames;

    public TrackDto() { }

    public TrackDto(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Long> genreIds) {
        this.genreIds = genreIds;
    }

    public List<String> getGenreNames() {
        return genreNames;
    }

    public void setGenreNames(List<String> genreNames) {
        this.genreNames = genreNames;
    }
}