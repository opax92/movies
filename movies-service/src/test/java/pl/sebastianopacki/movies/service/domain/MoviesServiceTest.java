package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.*;
import org.junit.Test;
import pl.sebastianopacki.movies.service.result.MovieResult;
import pl.sebastianopacki.movies.service.result.MovieResultFailure;
import pl.sebastianopacki.movies.service.result.MovieResultSuccess;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by seb on 05.01.18.
 */

public class MoviesServiceTest {

    private MoviesRepository moviesRepository = new MockMoviesRepository();
    private MoviesService moviesService = new MoviesService(moviesRepository);
    private List<MovieDTO> movies = new ArrayList<>();
    private MovieResult movieResult;
    private Integer currentId = 0;

    @Test
    public void addOneMovie() {
        //given
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "two").create();

        //when
        addMovies();

        //then
        assertResultSuccess();
        assertCountMovies(1);
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "two").exists();
    }


    @Test
    public void addMovieWithWrongTitle(){
        //given
        movieTitle("title3").withRating(2.4).withDirector("director").withActors("one", "dwa").create();

        //when
        addMovies();

        //then
        assertResultFailure();
    }

    @Test
    public void addMultipleMovies() {
        //given
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "dwa").create();
        movieTitle("titleTwo").withRating(4.0).withDirector("director2").withActors("one2", "dwa").create();
        movieTitle("titleThree").withRating(3.4).withDirector("director3").withActors("one3", "dwa", "tree").create();

        //when
        addMovies();

        //then
        assertResultSuccess();
        assertCountMovies(3);
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "dwa").exists();
        movieTitle("titleTwo").withRating(4.0).withDirector("director2").withActors("one2", "dwa").exists();
        movieTitle("titleThree").withRating(3.4).withDirector("director3").withActors("one3", "dwa", "tree").exists();
    }

    @Test
    public void removeMovie() {
        //given
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "dwa").create();
        addMovies();

        //when
        removeMovieWithId(0);

        //then
        assertResultSuccess();
        assertCountMovies(0);
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "dwa").notExists();
    }

    @Test
    public void getAllMoviesSortedByRating() {
        //given
        movieTitle("title").withRating(2.4).withDirector("director").withActors("one", "dwa").create();
        movieTitle("titleTwo").withRating(1.6).withDirector("director2").withActors("one2", "dwa").create();
        movieTitle("titleThree").withRating(4.4).withDirector("director3").withActors("one3", "dwa", "tree").create();
        movieTitle("titleFour").withRating(3.8).withDirector("director3").withActors("one3", "dwa", "tree").create();

        //when
        addMovies();

        //then
        assertResultSuccess();
        assertMoviesOrderByTitle("titleThree", "titleFour", "title", "titleTwo");
    }

    private void assertMoviesOrderByTitle(String... titles) {
        List<MovieDTO> allMoviesSortedByRating = moviesService.findAllMoviesSortedByRating();

        for(int i = 0; i < titles.length; ++i){
            assertTrue(allMoviesSortedByRating.get(i).getTitle().equals(titles[i]));
        }
    }

    private MoviesConfiguration movieTitle(String title) {
        return new MoviesConfiguration(title);
    }

    private void addMovies() {
        for (MovieDTO movie : movies) {
            movieResult = moviesService.createMovie(movie);
        }
    }

    private void assertCountMovies(Integer count){
        assertEquals(count, moviesRepository.count());
    }

    private void assertResultSuccess(){
        assertTrue(movieResult instanceof MovieResultSuccess);
    }

    private void assertResultFailure(){
        assertTrue(movieResult instanceof MovieResultFailure);
    }

    private void removeMovieWithId(Integer id){
        moviesService.deleteMovie(new MovieIdDTO(id));
    }

    private class MoviesConfiguration {
        private String title;
        private Double rate;
        private String director;
        private Set<String> actors = new HashSet<>();

        private MoviesConfiguration(String title) {
            this.title = title;
        }

        private MoviesConfiguration withRating(Double rating) {
            rate = rating;

            return this;
        }

        private MoviesConfiguration withDirector(String director) {
            this.director = director;

            return this;
        }

        private MoviesConfiguration withActors(String... actors) {
            Collections.addAll(this.actors, actors);

            return this;
        }

        private void create() {
            MovieDTO movie = new MovieDTO(title, rate, actors, director, new Date());
            movie.setId(currentId++);
            movies.add(movie);
        }

        private void exists() {
            MovieDTO movie = new MovieDTO(title, rate, actors, director, new Date());
            List<MovieDTO> allMoviesSortedByRating = moviesService.findAllMoviesSortedByRating();
            assertTrue(allMoviesSortedByRating.contains(movie));
        }

        private void notExists() {
            MovieDTO movie = new MovieDTO(title, rate, actors, director, new Date());
            List<MovieDTO> allMoviesSortedByRating = moviesService.findAllMoviesSortedByRating();//TODO copy paste
            assertFalse(allMoviesSortedByRating.contains(movie));
        }
    }
}