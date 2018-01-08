package pl.sebastianopacki.movies.service.result;

/**
 * Created by seb on 08.01.18.
 */
public class MovieResultSuccess extends MovieResult{

    public MovieResultSuccess() {
        super(true);
    }

    public boolean isSuccess(){
        return super.isSuccess();
    }
}
