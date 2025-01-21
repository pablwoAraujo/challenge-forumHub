CREATE TABLE user_profiles
(
   id UUID PRIMARY KEY,
   user_id UUID NOT NULL,
   profile_id UUID NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id),
   CONSTRAINT fk_profile_id FOREIGN KEY (profile_id) REFERENCES profiles (id)
);