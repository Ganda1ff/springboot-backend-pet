package ru.ivanr.music.repository;

import ru.ivanr.music.entity.Track;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
@Transactional 
public class TrackRepository {
    
    private final EntityManager em;

    public TrackRepository(EntityManager em) {
        this.em = em;
    } 

    public List<Track> findAll() {
        return em
        .createQuery("SELECT t FROM Track t", Track.class)
        .getResultList(); 
    }

    public Optional<Track> findById(Long id) {
        return em
        .createQuery("SELECT t from Track t WHERE t.id=:id", Track.class)
        .setParameter("id", id)
        .getResultStream()
        .findFirst();
    } 

    public Track create(Track track) {   
        em.persist(track);
        return track;
    }

    public int update(Track track, Long id) {
        int isUpdated = em.createQuery("UPDATE Track t SET t.name=:name, t.duration=:duration, t.album=:album WHERE t.id=:id")
        .setParameter("id", id)
        .setParameter("name", track.getName())
        .setParameter("duration", track.getDuration())
        .setParameter("album", track.getAlbum())
        .executeUpdate();
        
        return isUpdated;       
    }

    public int delete(Track track) {
        int isDeleted = em.createQuery("DELETE FROM Track t WHERE t.id=:id")
        .setParameter("id", track.getId())
        .executeUpdate();

        em.detach(track);

        return isDeleted;
    }
}
