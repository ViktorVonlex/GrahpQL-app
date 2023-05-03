INSERT INTO author (first_name, last_name, birth_date, country) VALUES ('Margaret', 'Atwood', '1939-11-18', 'Canada');
INSERT INTO author (first_name, last_name, birth_date, country) VALUES ('Neil', 'Gaiman', '1960-11-10', 'England');
INSERT INTO author (first_name, last_name, birth_date, country) VALUES ('Octavia', 'Butler', '1947-06-22', 'USA');

INSERT INTO publisher (name, location) VALUES ('Penguin Random House', 'New York, NY');
INSERT INTO publisher (name, location) VALUES ('HarperCollins', 'London, UK');
INSERT INTO publisher (name, location) VALUES ('Hachette Livre', 'Paris, France');

INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('The Handmaid''s Tale', '9780385490818', 1985, 1, 1);
INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('American Gods', '9780062572233', 2001, 2, 2);
INSERT INTO book (title, isbn, year, author_id, publisher_id) VALUES ('Parable of the Sower', '9780446675505', 1993, 3, 3);