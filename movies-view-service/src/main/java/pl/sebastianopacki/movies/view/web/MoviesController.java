package pl.sebastianopacki.movies.view.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by seb on 07.01.18.
 */
@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

    @RequestMapping(method = GET)
    @ResponseBody
    public String test(){
        return "elo";
    }
}
