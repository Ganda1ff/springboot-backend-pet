package ru.ivanr.music.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="artists")
public class Artist extends BaseEntity {

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name="birth_country", nullable = false)
    private String birthCountry;

    //@JsonIgnore
    @OneToMany(mappedBy="artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Album> albums = new HashSet<>();

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

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }


}
