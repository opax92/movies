package pl.sebastianopacki.movies.service.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class MovieId implements Serializable{

    private Integer id;

    public MovieId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
