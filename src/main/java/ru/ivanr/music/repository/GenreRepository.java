package ru.ivanr.music.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivanr.music.entity.Genre;

@Repository
public interface GenreRepository
 extends JpaRepository<Genre, Long> {
    
 }