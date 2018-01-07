package pl.sebastianopacki.movies.service.domain;

import javax.persistence.Embeddable;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Id {

    private Integer id;

    public Id(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
