INSERT INTO author (first_name, last_name, birth_date, country) VALUES ('Margaret', 'Atwood', '1939-11-18', 'Canada');
INSERT INTO author (first_name, last_name, birth_date, country) VALUES ('Neil', 'Gaiman', '1960-11-10', 'England');
INSERT INTO author (first_name, last_name, birth_date, country) VALUES ('Octavia', 'Butler', '1947-06-22', 'USA');

INSERT INTO city (name) VALUES ('New York');
INSERT INTO city (name) VALUES ('London');

INSERT INTO publisher (name, location, city_id) VALUES ('Penguin Random House', 'New York, NY', 1);
INSERT INTO publisher (name, location, city_id) VALUES ('HarperCollins', 'London, UK', 1);
INSERT INTO publisher (name, location, city_id) VALUES ('Hachette Livre', 'Paris, France', 2);

INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('The Handmaid''s Tale', '9780385490818', 1985, 1, 1);
INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('Nejlepsi knizka', '1231244232423', 1985, 1, 2);
INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('American Gods', '9780062572233', 2001, 2, 2);
INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('Parable of the Sower', '9780446675505', 1993, 3, 3);

-- inserts for work test
INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('Top knizka', '23123432423', 1999, 2, 3);
INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('Codex', '23242365567423', 1995, 1, 3);
INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('Posledni', '25345375656756', 1995, 1, 3);

