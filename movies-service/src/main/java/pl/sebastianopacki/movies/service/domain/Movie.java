package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.MovieDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by seb on 05.01.18.
 */
@Entity
@Table(name="movie_tbl")
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    private Title title;
    private Rate rate;
    private Actors actors;
    private Director director;

    public Movie() {
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

    Optional<Rate> getRate() {
        return Optional.ofNullable(rate);
    }

    Actors getActors() {
        return actors;
    }

    Optional<Director> getDirector() {
        return Optional.ofNullable(director);
    }

    Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return
                Objects.equals(title, movie.title) &&
                Objects.equals(rate, movie.rate) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, rate, actors, director);
    }
}
