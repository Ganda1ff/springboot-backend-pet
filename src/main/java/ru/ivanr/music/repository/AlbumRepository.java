package ru.ivanr.music.repository;

import ru.ivanr.music.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository 
extends JpaRepository<Album, Long>  {
    
}
