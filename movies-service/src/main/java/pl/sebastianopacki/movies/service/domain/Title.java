package pl.sebastianopacki.movies.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sebastianopacki.movies.service.exceptions.InvalidTitleMovieException;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
public class Title implements Serializable {

    private String title;

    private Title() {
    }

    Title(String title, TitleValidator titleValidator) {
        if(Objects.isNull(title) || !titleValidator.validateTitle(title)){
            throw new InvalidTitleMovieException();
        }

        this.title = title;
    }

    String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return Objects.equals(title, title1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
