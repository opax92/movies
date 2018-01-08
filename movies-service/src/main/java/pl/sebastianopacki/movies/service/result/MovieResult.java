package pl.sebastianopacki.movies.service.result;

/**
 * Created by seb on 08.01.18.
 */
public abstract class MovieResult {
    private boolean isSuccess;

    MovieResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    protected boolean isSuccess(){
        return isSuccess;
    }
}
