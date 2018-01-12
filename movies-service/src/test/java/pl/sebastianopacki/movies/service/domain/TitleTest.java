package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.exceptions.InvalidTitleMovieException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seb on 07.01.18.
 */
public class TitleTest {

    private Title title;
    private String rowTitle;

    @Test
    public void simpleTitle() {
        //given
        titleCreate("simpleTitle");

        //when
        addTitle();

        //then
        titleCreatedSuccess();
    }

    @Test(expected = InvalidTitleMovieException.class)
    public void titleContainsNumbers() {
        //given
        titleCreate("simple5Title");

        //when
        addTitle();
    }

    @Test(expected = InvalidTitleMovieException.class)
    public void titleTooShort() {
        //given
        titleCreate("gg");

        //when
        addTitle();
    }


    @Test(expected = InvalidTitleMovieException.class)
    public void titleTooLong() {
        //given
        titleCreate("asdajsdiocaiosjdoiajsdionciaocaiocasiocasoicasiodha");

        //when
        addTitle();
    }

    private void titleCreate(String simpleTitle) {
        rowTitle = simpleTitle;
    }

    private void addTitle() {
        title = new Title(rowTitle, new TitleValidatorImpl());
    }

    private void titleCreatedSuccess() {
        assertFalse(title.getTitle().isEmpty());
    }
}