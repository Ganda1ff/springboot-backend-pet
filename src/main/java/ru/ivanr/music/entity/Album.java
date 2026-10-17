package ru.ivanr.music.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity 
@Table(name="albums")
public class Album extends BaseEntity {
    
@Column(name="name", nullable = false)
    private String name;

    @Column(name="release_date", nullable = false)
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name="artist_id")
    private Artist artist;

    public Album() {

    }

    public Album(String name, LocalDate releaseDate, Artist artist) {
        this. name = name;
        this.releaseDate = releaseDate;
        this.artist = artist;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
