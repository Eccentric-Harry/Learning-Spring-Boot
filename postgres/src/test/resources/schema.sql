-- H2-compatible schema for testing
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

-- Create authors table
CREATE TABLE authors(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INTEGER
);

-- Create books table
CREATE TABLE books(
    isbn VARCHAR(255) PRIMARY KEY,
    title VARCHAR(255),
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);
