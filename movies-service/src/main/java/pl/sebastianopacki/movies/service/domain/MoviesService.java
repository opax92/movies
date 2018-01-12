package pl.sebastianopacki.movies.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sebastianopacki.movies.service.dto.MovieDTO;
import pl.sebastianopacki.movies.service.dto.MovieIdDTO;
import pl.sebastianopacki.movies.service.exceptions.InvalidMovieRatingException;
import pl.sebastianopacki.movies.service.exceptions.MovieException;
import pl.sebastianopacki.movies.service.exceptions.IncorrectMovieIdException;
import pl.sebastianopacki.movies.service.result.MovieFailureResultReason;
import pl.sebastianopacki.movies.service.result.MovieResult;
import pl.sebastianopacki.movies.service.result.MovieResultFailure;
import pl.sebastianopacki.movies.service.result.MovieResultSuccess;

import java.util.*;

import static pl.sebastianopacki.movies.service.result.MovieFailureResultReason.MOVIE_WITH_TITLE_ALREADY_EXISTS;

/**
 * Created by seb on 05.01.18.
 */
@Service
class MoviesService {

    private final MoviesRepository moviesRepository;

    @Autowired
    MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    MovieResult createMovie(MovieDTO movieDTO) {
        Movie movie;
        try {
            movie = new Movie(movieDTO);
        } catch (MovieException e) {
            return new MovieResultFailure(MovieFailureResultReason.valueOf(e.getMessage()));
        }

        if (movieWithThatTitleAlreadyExists(movie)) {
            return new MovieResultFailure(MOVIE_WITH_TITLE_ALREADY_EXISTS);
        }

        moviesRepository.createMovie(movie);

        return new MovieResultSuccess();
    }

    List<MovieDTO> findAllMoviesSortedByRating() {
        List<Movie> allMoviesSortedByRating = moviesRepository.findAllMovies();
        allMoviesSortedByRating.sort(Comparator.comparing(o -> o.getRating().orElseThrow(InvalidMovieRatingException::new).getRate()));
        Collections.reverse(allMoviesSortedByRating);

        return MovieDTOConverter.convertToDTO(allMoviesSortedByRating);
    }

    void deleteMovie(MovieIdDTO movieIdDTO) {
        if(nullMovieId(movieIdDTO) || movieWithIdNotExists(movieIdDTO)) {
            throw new IncorrectMovieIdException();
        }

        moviesRepository.deleteMovie(movieIdDTO.getId());
    }

    private boolean movieWithThatTitleAlreadyExists(Movie movie){
        return moviesRepository.findMovieByTitle(movie.getTitle()).isPresent();
    }

    private boolean movieWithIdNotExists(MovieIdDTO movieIdDTO){
        return !moviesRepository.findMovieById(movieIdDTO.getId()).isPresent();
    }

    private boolean nullMovieId(MovieIdDTO movieIdDTO){
        return Objects.isNull(movieIdDTO) || Objects.isNull(movieIdDTO.getId());
    }
}
