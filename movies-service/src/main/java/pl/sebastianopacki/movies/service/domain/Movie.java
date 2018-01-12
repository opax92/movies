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
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    private Title title;
    private Rating rating;
    private Actors actors;
    private Director director;

    public Movie() {
    }

    Movie(MovieDTO movieDTO) {
        this.id = movieDTO.getId();
        this.title = new Title(movieDTO.getTitle(), new TitleValidatorImpl());
        this.rating = new Rating(movieDTO.getRating());
        this.actors = new Actors(movieDTO.getActors());
        this.director = new Director(movieDTO.getDirector());
    }

    Integer getId() {
        return id;
    }

    Title getTitle() {
        return title;
    }

    Optional<Rating> getRating() {
        return Optional.ofNullable(rating);
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
                        Objects.equals(rating, movie.rating) &&
                        Objects.equals(actors, movie.actors) &&
                        Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, rating, actors, director);
    }
}
