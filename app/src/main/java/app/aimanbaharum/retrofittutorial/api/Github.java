package app.aimanbaharum.retrofittutorial.api;

import app.aimanbaharum.retrofittutorial.model.GitModel;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by piracyde25 on 5/18/2015.
 */
public interface Github {

    @GET("/users/{user}")
    GitModel getFeed(@Path("user") String user);
}
