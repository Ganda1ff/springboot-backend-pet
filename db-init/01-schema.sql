-- CREATE DATABASE music_catalogue;
CREATE TABLE IF NOT EXISTS artists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    birth_country VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS albums (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    release_date DATE NOT NULL,
    artist_id INT NOT NULL REFERENCES artists(id)  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS tracks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    length_sec INT NOT NULL,
    album_id INT NOT NULL REFERENCES albums(id) ON DELETE CASCADE,
    CONSTRAINT check_len CHECK (length_sec > 0)
);

CREATE TABLE IF NOT EXISTS genres (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS genres_tracks (
    genre_id INT NOT NULL REFERENCES genres(id) ON DELETE CASCADE,
    track_id INT NOT NULL REFERENCES tracks(id) ON DELETE CASCADE,
    PRIMARY KEY(genre_id, track_id)
);