package pl.sebastianopacki.movies.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sebastianopacki.movies.service.domain.Movie;
import pl.sebastianopacki.movies.service.domain.MoviesRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by seb on 07.01.18.
 */
@Repository
@Transactional
public class MoviesRepositoryImp implements MoviesRepository {

    private final SessionFactory postgresqlHibernateSessionFactory;

    @Autowired
    public MoviesRepositoryImp(SessionFactory postgresqlHibernateSessionFactory) {
        this.postgresqlHibernateSessionFactory = postgresqlHibernateSessionFactory;
    }

    public List<Movie> findAllMovies() {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        Query select = currentSession.createQuery("from Movie as movie where movie.title = :title");
        select.setParameter("title", "a");

        return null;
    }

    public void deleteMovie(Integer id) {

    }

    public void createMovie(Movie movie) {

    }

    public Integer count() {
        return null;
    }
}
