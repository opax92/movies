package pl.sebastianopacki.movies.service.domain;

import java.util.List;

/**
 * Created by seb on 05.01.18.
 */
public interface MoviesRepository {

    List<Movie> findAllMovies();

    void deleteMovie(Integer id);

    void createMovie(Movie movie);

    Integer count();
}
