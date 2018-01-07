package pl.sebastianopacki.movies.service.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Director implements Serializable {

    private String director;

    private Director() {
    }

    public Director(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }
}
