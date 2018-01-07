package pl.sebastianopacki.movies.service.domain;

import pl.sebastianopacki.movies.service.dto.ActorDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by seb on 05.01.18.
 */
@Entity
@Table(name = "actor_tbl")
class Actor implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String actor;

    public Actor() {
    }

    public Actor(String actor) {
        this.actor = actor;
    }

    public Actor(ActorDTO actorDTO){
        this.actor = actorDTO.getActor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(this.actor, actor.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor);
    }

    public String getActor() {
        return actor;
    }
}
