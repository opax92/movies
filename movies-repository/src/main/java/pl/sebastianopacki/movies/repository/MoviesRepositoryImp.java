package pl.sebastianopacki.movies.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sebastianopacki.movies.service.domain.Movie;
import pl.sebastianopacki.movies.service.domain.MoviesRepository;
import pl.sebastianopacki.movies.service.domain.Title;

import java.util.List;
import java.util.Optional;

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

    @SuppressWarnings("unchecked")
    public List<Movie> findAllMovies() {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Movie");

        return query.list();
    }

    @Override
    public Optional<Movie> findMovieByTitle(Title title) {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Movie as movie where movie.title = :title");
        query.setParameter("title", title);

        return Optional.ofNullable((Movie) query.uniqueResult());
    }

    @Override
    public Optional<Movie> findMovieById(Integer id) {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Movie as movie where movie.id = :id");
        query.setParameter("id", id);

        return Optional.ofNullable((Movie) query.uniqueResult());
    }

    public void deleteMovie(Integer movieId) {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        currentSession.delete(currentSession.load(Movie.class, movieId));
    }

    public void createMovie(Movie movie) {
        Session currentSession = postgresqlHibernateSessionFactory.getCurrentSession();
        currentSession.save(movie);
    }
}
