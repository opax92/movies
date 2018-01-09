package pl.sebastianopacki.movies.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by seb on 07.01.18.
 */
@SpringBootApplication
@ComponentScan("pl.sebastianopacki")
public class MoviesSpringBootStarter extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(MoviesSpringBootStarter.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MoviesSpringBootStarter.class);
    }
}
