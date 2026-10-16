package ru.ivanr.music.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="artists")
public class Artist extends BaseEntity {

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name="birth_country", nullable = false)
    private String birthCountry;

    public Artist() {

    }

    public Artist(String name, LocalDate birthDate, String birthCountry) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthCountry = birthCountry;
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
