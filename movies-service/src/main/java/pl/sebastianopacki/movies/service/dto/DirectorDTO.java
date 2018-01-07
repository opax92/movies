package pl.sebastianopacki.movies.service.dto;

import java.util.Objects;

/**
 * Created by seb on 06.01.18.
 */
public class DirectorDTO {
    private String director;

    public DirectorDTO(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorDTO that = (DirectorDTO) o;
        return Objects.equals(director, that.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
