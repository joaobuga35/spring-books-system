
CREATE TABLE users (
  id CHAR(36) PRIMARY KEY,
  name CHAR(255),
  email VARCHAR(255),
  password CHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE authors (
  id CHAR(36) PRIMARY KEY,
  name CHAR(255),
  idade INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE books (
  id CHAR(36) PRIMARY KEY,
  name CHAR(255),
  release_year DATE,
  image VARCHAR(255),
  price DOUBLE,
  in_stock BOOLEAN,
  author_id CHAR(36),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (author_id) REFERENCES authors(id)
);