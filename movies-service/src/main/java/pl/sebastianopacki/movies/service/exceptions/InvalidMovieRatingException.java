package pl.sebastianopacki.movies.service.exceptions;

import static pl.sebastianopacki.movies.service.result.MovieFailureResultReason.INVALID_MOVIE_RATING;

/**
 *
 * @author Seb
 */
public class InvalidMovieRatingException extends MovieException {
    public InvalidMovieRatingException() {
        super(INVALID_MOVIE_RATING.toString());
    }
}
