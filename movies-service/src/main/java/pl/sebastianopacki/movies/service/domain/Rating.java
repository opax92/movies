package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.exceptions.InvalidMovieRatingException;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Rating implements Serializable {

    private Double rating;

    private Rating() {
    }

    Rating(Double rating) {
        if(Objects.isNull(rating)){
            throw new InvalidMovieRatingException();
        }
        this.rating = rating;
    }

    Double getRate() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Objects.equals(rating, rating1.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating);
    }
}
