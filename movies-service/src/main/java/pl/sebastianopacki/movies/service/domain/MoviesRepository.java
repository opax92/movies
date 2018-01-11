package pl.sebastianopacki.movies.service.domain;

import java.util.List;
import java.util.Optional;

/**
 * Created by seb on 05.01.18.
 */
public interface MoviesRepository {

    List<Movie> findAllMovies();

    Optional<Movie> findMovieByTitle(Title title);

    Optional<Movie> findMovieById(Integer id);

    void deleteMovie(Integer id);

    void createMovie(Movie movie);
}
