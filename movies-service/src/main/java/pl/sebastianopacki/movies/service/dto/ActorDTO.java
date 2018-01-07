package pl.sebastianopacki.movies.service.dto;

import java.util.Objects;

/**
 * Created by seb on 06.01.18.
 */
public class ActorDTO {
    private String actor;

    public ActorDTO(String actor) {
        this.actor = actor;
    }


    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDTO actorDTO = (ActorDTO) o;
        return Objects.equals(actor, actorDTO.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor);
    }
}
