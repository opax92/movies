DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence INCREMENT BY 1 MINVALUE 1 CACHE 1 NO CYCLE;

DROP TABLE IF EXISTS movie_actors CASCADE;

CREATE TABLE movie_actors 
(
  movie_id   INTEGER NOT NULL,
  actors     text
);

DROP TABLE IF EXISTS movie CASCADE;

CREATE TABLE movie 
(
  id          INTEGER NOT NULL,
  director    text,
  rating      float8,
  title       text,
  createdat   TIMESTAMP
);

ALTER TABLE movie ADD CONSTRAINT movie_tbl_pkey PRIMARY KEY (id);

ALTER TABLE movie_actors ADD CONSTRAINT movie_id FOREIGN KEY (movie_id) REFERENCES movie (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

