package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.DirectorDTO;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Director implements Serializable {

    private String director;

    public Director() {
    }

    public Director(String director) {
        this.director = director;
    }

    public Director(DirectorDTO directorDTO){
        this.director = directorDTO.getDirector();
    }

    public String getDirector() {
        return director;
    }
}
