package ru.ivanr.music.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="genres")
public class Genre extends BaseEntity {
    
    @Column(name="name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Track> tracks = new HashSet<>();

    public Genre() { }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

}
