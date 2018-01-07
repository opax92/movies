package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.DirectorDTO;

import javax.persistence.Embeddable;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Director {

    private String directorName;

    public Director(String directorName) {
        this.directorName = directorName;
    }

    public Director(DirectorDTO directorDTO){
        this.directorName = directorDTO.getDirector();
    }

    public String getDirectorName() {
        return directorName;
    }
}
