package pl.sebastianopacki.movies.service.exceptions;

import pl.sebastianopacki.movies.service.result.MovieFailureResultReason;

/**
 * Created by seb on 07.01.18.
 */
public class InvalidTitleMovieException extends MovieException {

    public InvalidTitleMovieException(){
        super(MovieFailureResultReason.INVALID_MOVIE_TITLE.toString());
    }
}
