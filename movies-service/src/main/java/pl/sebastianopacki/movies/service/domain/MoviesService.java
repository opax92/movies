package pl.sebastianopacki.movies.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sebastianopacki.movies.service.dto.MovieDTO;
import pl.sebastianopacki.movies.service.dto.MovieIdDTO;
import pl.sebastianopacki.movies.service.exceptions.InvalidTitleMovieException;
import pl.sebastianopacki.movies.service.result.MovieResult;
import pl.sebastianopacki.movies.service.result.MovieResultFailure;
import pl.sebastianopacki.movies.service.result.MovieResultSuccess;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.sebastianopacki.movies.service.result.MovieFailureResultReason.INVALID_TITLE_MOVIE;
import static pl.sebastianopacki.movies.service.result.MovieFailureResultReason.MOVIE_WITH_TITLE_ALREADY_EXISTS;

/**
 * Created by seb on 05.01.18.
 */
@Service
@Transactional
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
        } catch (InvalidTitleMovieException e) {
            return new MovieResultFailure(INVALID_TITLE_MOVIE);
        }

        if (movieWithThatTitleAlreadyExists(movie)) {
            return new MovieResultFailure(MOVIE_WITH_TITLE_ALREADY_EXISTS);
        }

        moviesRepository.createMovie(movie);
        return new MovieResultSuccess();
    }

    List<MovieDTO> findAllMoviesSortedByRating() {
        List<Movie> allMovies = moviesRepository.findAllMovies();
        allMovies.sort(Comparator.comparing(o -> o.getRate().get().getRate()));
        Collections.reverse(allMovies);

        return convertToDTO(allMovies);
    }

    void deleteMovie(MovieIdDTO movieIdDTO) {
        moviesRepository.deleteMovie(movieIdDTO.getId());
    }

    private boolean movieWithThatTitleAlreadyExists(Movie movie){
        return moviesRepository.findMovieByTitle(movie.getTitle()).isPresent();
    }

    private MovieDTO convertToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle().getTitle());
        movieDTO.setActors(movie.getActors().getActors());
        movieDTO.setCreatedAt(movie.getCreatedAt());
        movieDTO.setRate(movie.getRate().orElse(new Rate(0.0)).getRate());
        movieDTO.setDirector(movie.getDirector().orElse(new Director("")).getDirector());

        return movieDTO;
    }

    private List<MovieDTO> convertToDTO(List<Movie> movies) {
        List<MovieDTO> moviesDTO = new ArrayList<>();
        for (Movie movie : movies) {
            moviesDTO.add(convertToDTO(movie));
        }

        return moviesDTO;
    }
}
