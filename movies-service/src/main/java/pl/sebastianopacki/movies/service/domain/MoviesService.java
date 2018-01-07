package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by seb on 05.01.18.
 */
@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public void addMovie(MovieDTO movie){
        moviesRepository.createMovie(new Movie(movie));
    }

    public List<MovieDTO> findAllMoviesSortedByRating(){
        List<Movie> allMovies = moviesRepository.findAllMovies();
        allMovies.sort(Comparator.comparing(o -> o.getRate().getRate()));
        Collections.reverse(allMovies);

        return convertToDTO(allMovies);
    }

    public void deleteMovie(Integer movieId){
        moviesRepository.deleteMovie(movieId);
    }

    private MovieDTO convertToDTO(Movie movie){
        MovieDTO result = new MovieDTO();
        result.setId(movie.getId());
        result.setDirector(movie.getDirector().getDirector());
        result.setTitle(movie.getTitle().getTitle());
        result.setRate(movie.getRate().getRate());
        result.setActors(movie.getActors().getActors());

        return result;
    }

    private List<MovieDTO> convertToDTO(List<Movie> movies){
        List<MovieDTO> result = new ArrayList<>();
        for(Movie movie : movies){
            result.add(convertToDTO(movie));
        }

        return result;
    }
}
