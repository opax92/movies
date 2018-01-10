package pl.sebastianopacki.movies.service.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Rating implements Serializable {

    private Double rate;

    private Rating() {
    }

    Rating(Double rate) {
        this.rate = rate;
    }

    Double getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Objects.equals(rate, rating1.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }
}
