package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by seb on 05.01.18.
 */
public class MoviesService {


    private MoviesRepository moviesRepository;

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

        return toDTO(allMovies);
    }

    public void deleteMovie(Integer movieId){
        moviesRepository.deleteMovie(movieId);
    }

    private List<MovieDTO> toDTO(List<Movie> movies){
        List<MovieDTO> result = new ArrayList<>();

        for(Movie movie : movies){
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setTitle(new TitleDTO(movie.getTitle().getTitle()));
            movieDTO.setDirector(new DirectorDTO(movie.getDirector().getDirectorName()));
            Set<ActorDTO> actorDTOS = new HashSet<>();
            for(Actor actor : movie.getActors()){
                actorDTOS.add(new ActorDTO(actor.getActorName()));
            }
            movieDTO.setActors(actorDTOS);
            movieDTO.setRate(new RateDTO(movie.getRate().getRate()));
            movieDTO.setId(movie.getId().getId());
            result.add(movieDTO);
        }

        return result;
    }
}
