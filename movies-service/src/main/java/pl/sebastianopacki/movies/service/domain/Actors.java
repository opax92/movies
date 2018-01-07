package pl.sebastianopacki.movies.service.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by seb on 07.01.18.
 */
@Embeddable
 class Actors {

    @ElementCollection(targetClass=String.class)
    private Set<String> actors;

    Actors(Set<String> actors) {
        this.actors = actors;
    }

    Set<String> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actors actors1 = (Actors) o;
        return Objects.equals(actors, actors1.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actors);
    }
}
