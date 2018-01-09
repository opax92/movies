package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.exceptions.InvalidTitleMovieException;

import javax.persistence.Embeddable;
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

    Title(String title) {
        if(Objects.isNull(title)){
            throw new InvalidTitleMovieException();
        }
        TitleValidator titleValidator = new TitleValidatorImpl(title);
        titleValidator.validateTitle(title);
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    private static class TitleValidatorImpl implements TitleValidator {

        private final String titleToValidate;

        private TitleValidatorImpl(String titleToValidate) {
            this.titleToValidate = titleToValidate;
        }

        @Override
        public void validateTitle(String title) {
            if (!titleContainsOnlyLetters() || !titleHasAtLeast3CharactersUpTo50()) {
                throw new InvalidTitleMovieException();
            }
        }

        private boolean titleHasAtLeast3CharactersUpTo50() {
            return titleToValidate.length() >= 3 && titleToValidate.length() <= 50;
        }

        private boolean titleContainsOnlyLetters() {
            return titleToValidate.chars().allMatch(Character::isLetter);
        }
    }
}
