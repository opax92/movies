package pl.sebastianopacki.movies.view.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastianopacki.movies.service.domain.MoviesService;
import pl.sebastianopacki.movies.service.dto.MovieDTO;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
    public List<MovieDTO> test(){
        return moviesService.findAllMoviesSortedByRating();
    }

    @RequestMapping(method = POST)
    public void create(@RequestBody MovieDTO movieDTO){
        moviesService.addMovie(movieDTO);
    }
}
