CREATE TABLE users
(
   id UUID PRIMARY KEY,
   name VARCHAR (128) NOT NULL,
   email VARCHAR (255) NOT NULL UNIQUE,
   password VARCHAR (255) NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);