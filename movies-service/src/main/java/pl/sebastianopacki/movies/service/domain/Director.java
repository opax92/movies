package pl.sebastianopacki.movies.service.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Director implements Serializable {

    private String director;

    private Director() {
    }

    Director(String director) {
        this.director = director;
    }

    String getDirector() {
        return director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director1 = (Director) o;
        return Objects.equals(director, director1.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director);
    }
}
