package pl.sebastianopacki.movies.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by seb on 07.01.18.
 */
@SpringBootApplication
@ComponentScan("pl.sebastianopacki")
public class MoviesSpringBootStarter {
    public static void main(String[] args) {
        SpringApplication.run(MoviesSpringBootStarter .class);
    }
}
