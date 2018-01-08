package pl.sebastianopacki.movies.repository.configuration;

/**
 * Created by seb on 07.01.18.
 */

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.sebastianopacki.movies.service.domain.Movie;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Seb
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(postgresDataSource());
        sessionBuilder.addAnnotatedClass(Movie.class);
        sessionBuilder.addProperties(hibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }

    @Bean
    @Primary
    public DataSource postgresDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        setConnectionProperties(dataSource);
        return dataSource;
    }

    private void setConnectionProperties(DriverManagerDataSource dataSource) {
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/movies");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.put("hibernate.show_sql", "false");
        return properties;
    }
}