package ru.ivanr.music.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tracks")
public class Track extends BaseEntity {

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="length_sec", nullable = false)
    private Integer duration;

    @ManyToOne 
    @JoinColumn(name="album_id")
    private Album album;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name="genres_tracks",
        joinColumns = @JoinColumn(name = "track_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )

    private Set<Genre> genres = new HashSet<>();

    public Track() {

    }

    public Track(String name, Integer duration, Album album) {
        this.name = name;
        this.duration = duration;
        this.album = album;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }


}
