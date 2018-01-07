package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.ActorDTO;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Created by seb on 05.01.18.
 */
@Embeddable
class Actor {

    private String actorName;

    public Actor(String actorName) {
        this.actorName = actorName;
    }

    public Actor(ActorDTO actorDTO){
        this.actorName = actorDTO.getActor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(actorName, actor.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName);
    }

    public String getActorName() {
        return actorName;
    }
}
