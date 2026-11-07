package ru.ivanr.music.dto;

import jakarta.validation.constraints.*;

public class GenreDto {

    Long id;

    @NotBlank 
    @Size(min = 2, max = 100)
    String name;

    public GenreDto() { }

    public GenreDto(String name) {
        this.name = name;
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

}
