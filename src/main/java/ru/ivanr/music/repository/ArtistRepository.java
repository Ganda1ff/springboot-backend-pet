package ru.ivanr.music.repository;

import ru.ivanr.music.entity.Artist;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Repository
@Transactional 
public class ArtistRepository {
    private final EntityManager em;

    public ArtistRepository(EntityManager em) {
        this.em = em;
    }

    public List<Artist> findAll() {
        return em
        .createQuery("SELECT a FROM Artist a", Artist.class)
        .getResultList();
    }

    public Artist findById(Long id) {

        Artist artist = em.find(Artist.class, id);

        if (artist == null) {
            throw new RuntimeException("Artist is null");
        }

        return artist;
    }

    public Artist save(Artist artist) {
        if (artist.getId() == null) {
            em.persist(artist);
        } else {
            em.merge(artist);
        }

        return artist;
    }

    public String deleteById(Long id) {
        Artist artist = em.find(Artist.class, id);

        if (artist != null) {
            em.remove(artist);
        } else {
            throw new RuntimeException("Artist is null");
        }

        return "Artist with id" + "[" + id + "] was removed";
    }
}
