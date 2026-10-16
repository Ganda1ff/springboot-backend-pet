package ru.ivanr.music.service;

import ru.ivanr.music.repository.ArtistRepository;
import ru.ivanr.music.entity.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Artist getById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        Artist artist = artistRepository.findById(id);

        return artist;
    }

    public Artist create(Artist artist) {

        if (artist == null) {
            throw new RuntimeException("artist is null");
        }

        Artist newArtist = artistRepository.save(artist);
        
        return newArtist;

    }

    public Artist update(Long id, Artist artist) {

        Artist newArtist = artistRepository.findById(id);

        if (newArtist == null) {
            throw new RuntimeException("Artist is null");
        }

        newArtist.setName(artist.getName());
        newArtist.setBirthDate(artist.getBirthDate());
        newArtist.setBirthCountry(artist.getBirthCountry());

        return artistRepository.save(newArtist);
    }

    public void delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        artistRepository.deleteById(id);
    }
    
    
}

    
