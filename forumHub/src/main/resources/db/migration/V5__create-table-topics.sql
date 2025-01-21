CREATE TABLE topics
(
   id UUID PRIMARY KEY,
   title VARCHAR (128) NOT NULL,
   message VARCHAR (16000),
   status VARCHAR (128),
   author_id UUID NOT NULL,
   course_id UUID NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT fk_topics_author FOREIGN KEY (author_id) REFERENCES users (id),
   CONSTRAINT fk_topics_course FOREIGN KEY (course_id) REFERENCES courses (id)
);