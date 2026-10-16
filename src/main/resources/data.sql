INSERT INTO artists (name, birth_date, birth_country) 
VALUES
    ('Macan', '1990-01-09', 'Russia'),
    ('Dora', '2000-02-01', 'Russia'),
    ('Oliver Tree', '1993-06-16', 'USA');

INSERT INTO albums (name, release_date, artist_id) 
VALUES
    ('Cupola', '2026-01-02', 1),
    ('DoraDura', '2025-11-11', 2),
    ('Oliver 200', '2001-11-09', 3);

INSERT INTO tracks (name, length_sec, album_id) 
VALUES
    ('Zolotye', 14, 1),
    ('SpiderMan', 88, 2),
    ('Onion', 200, 3);

INSERT INTO genres (name) 
VALUES
    ('Rap'),
    ('Pop'),
    ('Rock');

INSERT INTO genres_tracks (genre_id, track_id) 
VALUES
    (1,1),
    (2,3),
    (3,2);
