package pl.sebastianopacki.movies.view.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastianopacki.movies.service.domain.MoviesFacade;
import pl.sebastianopacki.movies.service.dto.MovieDTO;
import pl.sebastianopacki.movies.service.dto.MovieIdDTO;
import pl.sebastianopacki.movies.service.result.MovieResult;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by seb on 07.01.18.
 */
@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

    private final MoviesFacade moviesFacade;

    @Autowired
    public MoviesController(MoviesFacade moviesService) {
        this.moviesFacade = moviesService;
    }

    @RequestMapping(method = GET)
    @ResponseBody
    public List<MovieDTO> findAllMovies(){
        return moviesFacade.findAllMoviesSortedByRating();
    }

    @RequestMapping(method = PUT)
    @ResponseBody
    public MovieResult createMovie(@RequestBody MovieDTO movieDTO){
        return moviesFacade.createMovie(movieDTO);
    }

    @RequestMapping(method = DELETE)
    public void deleteMovie(@RequestBody MovieIdDTO movieId){
        moviesFacade.deleteMovie(movieId);
    }
}
