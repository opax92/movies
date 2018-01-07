package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by seb on 05.01.18.
 */

public class MoviesServiceTest {
    private MoviesRepository moviesRepository = new MockMoviesRepository();
    private MoviesService moviesService = new MoviesService(moviesRepository);
    private List<MovieDTO> movies = new ArrayList<>();
    private Integer currentId = 0;

    @Test
    public void addOneMovie() {
        //given
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "two").create();

        //when
        addMovies();

        //then
        assertCountMovies(1);
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "two").exists();
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
        assertCountMovies(0);
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "dwa").notExists();
    }

    @Test
    public void removeNotExistsMovie() {
        //given
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "dwa").create();
        movieTitle("titleTwo").withRating(3.0).withDirector("director2").withActors("one", "dwa").create();
        addMovies();

        //when
        removeMovieWithId(3);

        //then
        assertCountMovies(2);
        movieTitle("title").withRating(5.0).withDirector("director").withActors("one", "dwa").exists();
        movieTitle("titleTwo").withRating(3.0).withDirector("director2").withActors("one", "dwa").exists();
//        assertMoviesResult(MOVIE_NOT_EXISTS);
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
        assertMoviesOrderByTitle("titleThree", "titleFour", "title", "titleTwo");
    }

    private void assertMoviesOrderByTitle(String... titles) {
        List<MovieDTO> allMoviesSortedByRating = moviesService.findAllMoviesSortedByRating();

        for(int i = 0; i < titles.length; ++i){
            assertTrue(allMoviesSortedByRating.get(i).getTitle().getTitle().equals(titles[i]));
        }
    }

    private MoviesConfiguration movieTitle(String title) {
        return new MoviesConfiguration(new TitleDTO(title));
    }

    private void addMovies() {
        for (MovieDTO movie : movies) {
            moviesService.addMovie(movie);
        }
    }

    private void assertCountMovies(Integer count){
        assertEquals(count, moviesRepository.count());
    }

    private void removeMovieWithId(Integer id){
        moviesService.deleteMovie(id);
    }

    private class MoviesConfiguration {
        private TitleDTO title;
        private RateDTO rate;
        private DirectorDTO director;
        private Set<ActorDTO> actors = new HashSet<>();

        private MoviesConfiguration(TitleDTO title) {
            this.title = title;
        }

        private MoviesConfiguration withRating(Double rating) {
            rate = new RateDTO(rating);

            return this;
        }

        private MoviesConfiguration withDirector(String director) {
            this.director = new DirectorDTO(director);

            return this;
        }

        private MoviesConfiguration withActors(String... actors) {
            for(String str : actors){
                this.actors.add(new ActorDTO(str));
            }

            return this;
        }

        private void create() {
            MovieDTO movie = new MovieDTO(title, rate, actors, director);
            movie.setId(currentId++);
            movies.add(movie);
        }

        private void exists() {
            MovieDTO movie = new MovieDTO(title, rate, actors, director);
            List<MovieDTO> allMoviesSortedByRating = moviesService.findAllMoviesSortedByRating();
            assertTrue(allMoviesSortedByRating.contains(movie));
        }

        private void notExists() {
            MovieDTO movie = new MovieDTO(title, rate, actors, director);
            List<MovieDTO> allMoviesSortedByRating = moviesService.findAllMoviesSortedByRating();//TODO copy paste
            assertFalse(allMoviesSortedByRating.contains(movie));
        }
    }
}