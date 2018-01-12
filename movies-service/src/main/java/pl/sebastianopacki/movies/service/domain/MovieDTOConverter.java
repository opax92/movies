package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.MovieDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seb
 */
class MovieDTOConverter {

    static List<MovieDTO> convertToDTO(List<Movie> movies) {
        List<MovieDTO> moviesDTO = new ArrayList<>();
        for (Movie movie : movies) {
            moviesDTO.add(convertToDTO(movie));
        }

        return moviesDTO;
    }

    private static MovieDTO convertToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle().getTitle());
        movieDTO.setActors(movie.getActors().getActors());
        movieDTO.setCreatedAt(movie.getCreatedAt());
        movieDTO.setRating(movie.getRating().orElse(new Rating(0.0)).getRate());
        movieDTO.setDirector(movie.getDirector().orElse(new Director("")).getDirector());

        return movieDTO;
    }
}
