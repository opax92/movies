package pl.sebastianopacki.movies.service.dto;

import java.util.Objects;

/**
 * Created by seb on 06.01.18.
 */
public class TitleDTO {

    private String title;

    public TitleDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleDTO titleDTO = (TitleDTO) o;
        return Objects.equals(title, titleDTO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
