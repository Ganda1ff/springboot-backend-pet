package ru.ivanr.music.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import java.util.HashSet;

@Entity 
@Table(name="albums")
public class Album extends BaseEntity {
    
@Column(name="name", nullable = false)
    private String name;

    @Column(name="release_date", nullable = false)
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name="artist_id")
    private Artist artist;

    @OneToMany(mappedBy="album", fetch = FetchType.LAZY)
    private Set<Track> tracks = new HashSet<>();

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

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }
}
