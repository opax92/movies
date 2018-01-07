package pl.sebastianopacki.movies.service.domain;

import java.util.*;

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
        int toRemove = -1;

        for (int i = 0; i < movies.size(); ++i) {
            if (movies.get(i).getId().getId().equals(id)) {
                toRemove = i;
            }
        }
        if (toRemove != -1) {
            movies.remove(toRemove);
        }
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
