package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.MovieDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by seb on 05.01.18.
 */
@Entity
@Table(name="movie_tbl")
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;
    private Title title;
    private Rate rate;

    @ElementCollection(targetClass=Actors.class)
    private Actors actors;
    private Director director;

    private Movie() {
    }

    Movie(MovieDTO movieDTO){
        this.id = movieDTO.getId();
        this.title = new Title(movieDTO.getTitle());
        this.rate = new Rate(movieDTO.getRate());
        this.actors = new Actors(movieDTO.getActors());
        this.director = new Director(movieDTO.getDirector());
    }

    Integer getId() {
        return id;
    }

    Title getTitle() {
        return title;
    }

    Rate getRate() {
        return rate;
    }

    Actors getActors() {
        return actors;
    }

    Director getDirector() {
        return director;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setTitle(Title title) {
        this.title = title;
    }

    private void setRate(Rate rate) {
        this.rate = rate;
    }

    private void setActors(Actors actors) {
        this.actors = actors;
    }

    private void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(rate, movie.rate) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, rate, actors, director);
    }
}
