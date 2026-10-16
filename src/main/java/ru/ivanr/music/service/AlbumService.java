package ru.ivanr.music.service;

import org.springframework.stereotype.Service;

import ru.ivanr.music.repository.AlbumRepository;
import ru.ivanr.music.entity.Album;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public Optional<Album> getById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        return albumRepository.findById(id);
    }

    public Album create(Album album) {
        if (album == null) {
            throw new RuntimeException("Album is null");
        }

        return albumRepository.save(album);
    }

    public Album update(Long id, Album album) {
        Album newAlbum = albumRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Album not found"));

        newAlbum.setName(album.getName());
        newAlbum.setReleaseDate(album.getReleaseDate());
        newAlbum.setArtist(album.getArtist());

        return albumRepository.save(newAlbum);
    }

    public void delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null(((");
        }

        albumRepository.deleteById(id);
    }
}
