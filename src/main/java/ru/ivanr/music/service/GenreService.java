package ru.ivanr.music.service;

import ru.ivanr.music.repository.GenreRepository;
import ru.ivanr.music.entity.Genre;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre getById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }

        return genreRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Genre not found"));
    }

    public Genre create(Genre genre) {
        if (genre == null) {
            throw new RuntimeException("Genre doesnt exist");
        }

        return genreRepository.save(genre);
    }

    public Genre update(Genre genre, Long id) {
        if (id == null) throw new RuntimeException("Id is null");
        if (genre == null) throw new RuntimeException("Genre is null");

        Genre updatedGenre = genreRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Genre no found"));

        updatedGenre.setName(genre.getName());
        return genreRepository.save(updatedGenre);
    }

    public void deleteById(Long id) {
        if (id == null) throw new RuntimeException("Id is null");

        Genre deletedGenre = genreRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Genre no found"));

        genreRepository.delete(deletedGenre);
    }
}
