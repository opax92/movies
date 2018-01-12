package pl.sebastianopacki.movies.service.exceptions;

/**
 *
 * @author Seb
 */
public class MovieException extends RuntimeException {
    MovieException(String message) {
        super(message);
    }

    public MovieException() {
    }
}
