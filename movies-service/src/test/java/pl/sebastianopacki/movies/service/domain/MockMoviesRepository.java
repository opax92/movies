package pl.sebastianopacki.movies.service.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seb on 06.01.18.
 */
public class MockMoviesRepository implements MoviesRepository {

    private List<Movie> movies = new ArrayList<>();

    @Override
    public List<Movie> findAllMovies() {
        return movies;
    }

    @Override
    public void deleteMovie(Integer id) {
        movies.removeIf((Movie m) -> m.getId().equals(id));
    }

    @Override
    public void createMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public Integer count() {
        return movies.size();
    }
}
