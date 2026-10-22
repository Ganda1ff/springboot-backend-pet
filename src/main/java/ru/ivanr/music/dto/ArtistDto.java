package ru.ivanr.music.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;


public class ArtistDto {
    Long id;

    @NotBlank 
    @Size(min = 1, max = 40)
    String name;

    @NotNull 
    LocalDate birthDate;

    @NotBlank 
    String birthCountry;

    public ArtistDto() { }

    public ArtistDto(String name, LocalDate birthDate, String birthCountry) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthCountry = birthCountry;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }
}