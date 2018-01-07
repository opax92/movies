package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.TitleDTO;
import pl.sebastianopacki.movies.service.exceptions.InvalidTitleMovieException;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Title {

    private final String title;

    Title(String title) {
        TitleValidator titleValidator = new TitleValidatorImpl(title);
        titleValidator.validateTitle(title);
        this.title = title;
    }

    Title(TitleDTO titleDTO){
        this(titleDTO.getTitle());
    }

    String getTitle() {
        return title;
    }

    private static class TitleValidatorImpl implements TitleValidator {

        private final String titleToValidate;

        private TitleValidatorImpl(String titleToValidate) {
            this.titleToValidate = titleToValidate;
        }

        @Override
        public void validateTitle(String title) {
            if (!isTitleContainsOnlyLetters() || !isTitleHaveAtLeast3CharactersUpTo50()) {
                throw new InvalidTitleMovieException();
            }
        }

        private boolean isTitleHaveAtLeast3CharactersUpTo50() {
            return titleToValidate.length() >= 3 && titleToValidate.length() <= 50;
        }

        private boolean isTitleContainsOnlyLetters() {
            return titleToValidate.chars().allMatch(Character::isLetter);
        }
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
