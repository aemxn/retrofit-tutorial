package app.aimanbaharum.retrofittutorial.loader;

/**
 * Created by piracyde25 on 5/18/2015.
 */
public interface Callback<D> {

    public abstract void onFailure(Exception ex);

    public abstract void onSuccess(D result);
}
