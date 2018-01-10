package pl.sebastianopacki.movies.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sebastianopacki.movies.service.dto.MovieDTO;
import pl.sebastianopacki.movies.service.dto.MovieIdDTO;
import pl.sebastianopacki.movies.service.result.MovieResult;

import java.util.List;

/**
 * Created by seb on 10.01.18.
 */
@Service
public class MoviesFacade {

    private final MoviesService moviesService;

    @Autowired
    public MoviesFacade(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    public MovieResult createMovie(MovieDTO movieDTO) {
        return moviesService.createMovie(movieDTO);
    }

    public List<MovieDTO> findAllMoviesSortedByRating() {
        return moviesService.findAllMoviesSortedByRating();
    }

    public void deleteMovie(MovieIdDTO movieIdDTO) {
        moviesService.deleteMovie(movieIdDTO);
    }
}
