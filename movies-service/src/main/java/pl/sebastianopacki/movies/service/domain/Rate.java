package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.RateDTO;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Rate implements Serializable {
    public Rate() {
    }

    private Double rate;

    Rate(Double rate) {
        this.rate = rate;
    }

    Rate(RateDTO rateDTO){
        this.rate = rateDTO.getRate();
    }

    Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate1 = (Rate) o;
        return Objects.equals(rate, rate1.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }
}
