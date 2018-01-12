package pl.sebastianopacki.movies.service.domain;

/**
 * Created by seb on 10.01.18.
 */
class TitleValidatorImpl implements TitleValidator {

    @Override
    public boolean validateTitle(String title) {
        return titleContainsOnlyLetters(title) && titleHasAtLeast3CharactersUpTo50(title);
    }

    private boolean titleHasAtLeast3CharactersUpTo50(String titleToValidate) {
        return titleToValidate.length() >= 3 && titleToValidate.length() <= 50;
    }

    private boolean titleContainsOnlyLetters(String titleToValidate) {
        for(int i = 0; i < titleToValidate.length(); ++i){
            Character character = titleToValidate.charAt(i);
            if(!Character.isLetter(character) && !Character.isSpaceChar(character)){
                return false;
            }
        }
        return true;
    }
}
