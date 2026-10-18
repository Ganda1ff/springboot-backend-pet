package ru.ivanr.music.repository;

import ru.ivanr.music.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository 
extends JpaRepository<Album, Long>  {
    
}
