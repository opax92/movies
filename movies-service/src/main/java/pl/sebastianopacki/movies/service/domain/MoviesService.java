package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sebastianopacki.movies.service.exceptions.InvalidTitleMovieException;
import pl.sebastianopacki.movies.service.result.MovieResult;
import pl.sebastianopacki.movies.service.result.MovieResultFailure;
import pl.sebastianopacki.movies.service.result.MovieResultSuccess;

import javax.transaction.Transactional;
import java.util.*;

import static pl.sebastianopacki.movies.service.result.MovieFailureResultReason.INVALID_TITLE_MOVIE;

/**
 * Created by seb on 05.01.18.
 */
@Service
@Transactional
public class MoviesService {

    private final MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public MovieResult createMovie(MovieDTO movieDTO) {
        Movie movie;
        try {
            movie = new Movie(movieDTO);
        }catch (InvalidTitleMovieException e){
            return new MovieResultFailure(INVALID_TITLE_MOVIE);
        }

        moviesRepository.createMovie(movie);
        return new MovieResultSuccess();
    }

    public List<MovieDTO> findAllMoviesSortedByRating() {
        List<Movie> allMovies = moviesRepository.findAllMovies();
        allMovies.sort(Comparator.comparing(o -> o.getRate().getRate()));
        Collections.reverse(allMovies);

        return convertToDTO(allMovies);
    }

    public void deleteMovie(MovieIdDTO movieIdDTO) {
        moviesRepository.deleteMovie(movieIdDTO.getId());
    }

    private MovieDTO convertToDTO(Movie movie) {
        MovieDTO result = new MovieDTO();
        result.setId(movie.getId());
        result.setDirector(movie.getDirector().getDirector());
        result.setTitle(movie.getTitle().getTitle());
        result.setRate(movie.getRate().getRate());
        result.setActors(movie.getActors().getActors());
        result.setCreatedAt(movie.getCreatedAt());

        return result;
    }

    private List<MovieDTO> convertToDTO(List<Movie> movies) {
        List<MovieDTO> result = new ArrayList<>();
        for (Movie movie : movies) {
            result.add(convertToDTO(movie));
        }

        return result;
    }
}
