package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.ActorDTO;
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
    private MovieId id;
    private Title title;
    private Rate rate;

    @ElementCollection(targetClass=Actor.class)
    private Set<Actor> actors;

    private Director director;

    public Movie() {
    }

    Movie(MovieDTO movieDTO){
        this.id = new MovieId(movieDTO.getId());
        this.title = new Title(movieDTO.getTitle());
        this.rate = new Rate(movieDTO.getRate());
        actors = new HashSet<>();
        for(ActorDTO actorDTO : movieDTO.getActors()){
            actors.add(new Actor(actorDTO));
        }
        this.director = new Director(movieDTO.getDirector());
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

    public void setId(MovieId id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public MovieId getId() {
        return id;
    }

    public Rate getRate() {
        return rate;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public Director getDirector() {
        return director;
    }
}
