package pl.sebastianopacki.movies.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by seb on 05.01.18.
 */
public class MovieDTO implements Serializable {

    private Integer id;
    private String title;
    private Double rating;
    private Set<String> actors;
    private String director;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:sss", timezone = "UTC")
    private Date createdAt;

    public MovieDTO() {
    }

    public MovieDTO(String title, Double rating, Set<String> actors, String director, Date createdAt) {
        this.title = title;
        this.rating = rating;
        this.actors = actors;
        this.director = director;
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<String> getActors() {
        return actors;
    }

    public void setActors(Set<String> actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return
                Objects.equals(title, movieDTO.title) &&
                        Objects.equals(rating, movieDTO.rating) &&
                        Objects.equals(actors, movieDTO.actors) &&
                        Objects.equals(director, movieDTO.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, rating, actors, director);
    }
}
