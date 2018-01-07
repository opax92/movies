package pl.sebastianopacki.movies.service.dto;

import java.util.Objects;
import java.util.Set;

/**
 * Created by seb on 05.01.18.
 */
public class MovieDTO {

    private Integer id;
    private TitleDTO title;
    private RateDTO rate;
    private Set<ActorDTO> actors;
    private DirectorDTO director;

    public MovieDTO(){}

    public MovieDTO(TitleDTO title, RateDTO rate, Set<ActorDTO> actors, DirectorDTO director) {
        this.title = title;
        this.rate = rate;
        this.actors = actors;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(TitleDTO title) {
        this.title = title;
    }

    public RateDTO getRate() {
        return rate;
    }

    public void setRate(RateDTO rate) {
        this.rate = rate;
    }

    public Set<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(Set<ActorDTO> actors) {
        this.actors = actors;
    }

    public DirectorDTO getDirector() {
        return director;
    }

    public void setDirector(DirectorDTO director) {
        this.director = director;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TitleDTO getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return
                Objects.equals(title, movieDTO.title) &&
                Objects.equals(rate, movieDTO.rate) &&
                Objects.equals(actors, movieDTO.actors) &&
                Objects.equals(director, movieDTO.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, rate, actors, director);
    }
}
