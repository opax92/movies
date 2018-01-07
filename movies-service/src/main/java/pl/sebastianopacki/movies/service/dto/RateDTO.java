package pl.sebastianopacki.movies.service.dto;

import java.util.Objects;

/**
 * Created by seb on 06.01.18.
 */
public class RateDTO {

    private Double rate;

    public RateDTO(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateDTO rateDTO = (RateDTO) o;
        return Objects.equals(rate, rateDTO.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
