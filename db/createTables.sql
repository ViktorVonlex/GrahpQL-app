CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE,
    country VARCHAR(50)
);

CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE publisher (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    city_id INTEGER REFERENCES city(id) ON DELETE SET NULL
);

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    isbn VARCHAR(20),
    year INTEGER,
    author_id INTEGER NOT NULL REFERENCES author(id) ON DELETE CASCADE,
    publisher_id INTEGER REFERENCES publisher(id) ON DELETE SET NULL
);

