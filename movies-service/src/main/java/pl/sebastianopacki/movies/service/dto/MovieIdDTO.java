package pl.sebastianopacki.movies.service.dto;

import java.io.Serializable;

/**
 * Created by seb on 08.01.18.
 */
public class MovieIdDTO implements Serializable {

    private Integer id;

    public MovieIdDTO() {
    }

    public MovieIdDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
