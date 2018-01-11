package pl.sebastianopacki.movies.view.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sebastianopacki.movies.service.exceptions.IncorrectMovieIdException;

/**
 * Created by seb on 11.01.18.
 */
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(IncorrectMovieIdException.class)
    public ResponseEntity incorrectMovieIdHandler() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity HttpMessageConversionHandler() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
