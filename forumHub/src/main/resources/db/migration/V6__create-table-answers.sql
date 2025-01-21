CREATE TABLE answers
(
   id UUID PRIMARY KEY,
   solution TEXT,
   topic_id UUID NOT NULL,
   author_id UUID NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT fk_answers_topic FOREIGN KEY (topic_id) REFERENCES topics (id),
   CONSTRAINT fk_answers_author FOREIGN KEY (author_id) REFERENCES users (id)
);