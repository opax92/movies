package pl.sebastianopacki.movies.service.result;

/**
 * Created by seb on 08.01.18.
 */
public class MovieResultFailure extends MovieResult{

    private MovieFailureResultReason movieFailureResultReason;

    public MovieResultFailure(MovieFailureResultReason movieFailureResultReason) {
        super(false);
        this.movieFailureResultReason = movieFailureResultReason;
    }

    public MovieFailureResultReason getMovieFailureResultReason() {
        return movieFailureResultReason;
    }

    public boolean isSuccess(){
        return super.isSuccess();
    }
}
