package pl.sebastianopacki.movies.service.dto;

import java.util.Objects;
import java.util.Set;

/**
 * Created by seb on 05.01.18.
 */
public class MovieDTO {

    private Integer id;
    private String title;
    private Double rate;
    private Set<String> actors;
    private String director;

    public MovieDTO(){}

    public MovieDTO(String title, Double rate, Set<String> actors, String director) {
        this.title = title;
        this.rate = rate;
        this.actors = actors;
        this.director = director;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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
        return Objects.equals(title, movieDTO.title) &&
                Objects.equals(rate, movieDTO.rate) &&
                Objects.equals(actors, movieDTO.actors) &&
                Objects.equals(director, movieDTO.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, rate, actors, director);
    }
}
