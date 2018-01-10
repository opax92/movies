DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence
       INCREMENT BY 1
       MINVALUE 1
       CACHE 1
       NO CYCLE;

DROP TABLE IF EXISTS movie_actors CASCADE;

CREATE TABLE movie_actors
(
   movie_id  integer        NOT NULL,
   actors    varchar(255)
);

DROP TABLE IF EXISTS movie CASCADE;

CREATE TABLE movie
(
   id         integer     NOT NULL,
   director   text,
   rate       float8,
   title      text,
   createdat  timestamp
);

ALTER TABLE public.movie
   ADD CONSTRAINT movie_tbl_pkey
   PRIMARY KEY (id);

ALTER TABLE movie_actors
  ADD CONSTRAINT movie_id FOREIGN KEY (movie_id)
  REFERENCES movie (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
