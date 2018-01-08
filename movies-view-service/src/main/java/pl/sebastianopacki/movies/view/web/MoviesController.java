package pl.sebastianopacki.movies.view.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastianopacki.movies.service.domain.MovieIdDTO;
import pl.sebastianopacki.movies.service.result.MovieResult;
import pl.sebastianopacki.movies.service.domain.MoviesService;
import pl.sebastianopacki.movies.service.dto.MovieDTO;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by seb on 07.01.18.
 */
@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

    private final MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @RequestMapping(method = GET)
    @ResponseBody
    public List<MovieDTO> findAllMovies(){
        return moviesService.findAllMoviesSortedByRating();
    }

    @RequestMapping(method = PUT)
    @ResponseBody
    public MovieResult createMovie(@RequestBody MovieDTO movieDTO){
        return moviesService.createMovie(movieDTO);
    }

    @RequestMapping(method = DELETE)
    public void deleteMovie(@RequestBody MovieIdDTO movieId){
        moviesService.deleteMovie(movieId);
    }
}
