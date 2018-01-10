package pl.sebastianopacki.movies.service.domain;

import org.springframework.stereotype.Component;
import pl.sebastianopacki.movies.service.exceptions.InvalidTitleMovieException;

/**
 * Created by seb on 10.01.18.
 */
class TitleValidatorImpl implements TitleValidator {

    @Override
    public boolean validateTitle(String title) {
        if (titleContainsOnlyLetters(title) && titleHasAtLeast3CharactersUpTo50(title)) {
            return true;
        }

        return false;
    }

    private boolean titleHasAtLeast3CharactersUpTo50(String titleToValidate) {
        return titleToValidate.length() >= 3 && titleToValidate.length() <= 50;
    }

    private boolean titleContainsOnlyLetters(String titleToValidate) {
        return titleToValidate.chars().allMatch(Character::isLetter);
    }
}
