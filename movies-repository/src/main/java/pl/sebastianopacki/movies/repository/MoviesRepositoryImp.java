package pl.sebastianopacki.movies.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sebastianopacki.movies.service.domain.Movie;
import pl.sebastianopacki.movies.service.domain.MoviesRepository;

import java.util.List;

/**
 * Created by seb on 07.01.18.
 */
@Repository
public class MoviesRepositoryImp implements MoviesRepository {

    private final SessionFactory postgresqlHibernateSessionFactory;

    @Autowired
    public MoviesRepositoryImp(SessionFactory postgresqlHibernateSessionFactory) {
        this.postgresqlHibernateSessionFactory = postgresqlHibernateSessionFactory;
    }

    public List<Movie> findAllMovies() {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        Query select = currentSession.createQuery("from Movie");

        return select.list();
    }

    public void deleteMovie(Integer movieId) {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Movie as movie where movie.id = :movieId");
        query.setParameter("movieId", movieId);
        query.executeUpdate();
    }

    public void createMovie(Movie movie) {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        currentSession.save(movie);
    }

    public Integer count() {
        return null;
    }
}
