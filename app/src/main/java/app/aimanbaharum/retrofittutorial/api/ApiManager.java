package app.aimanbaharum.retrofittutorial.api;

import app.aimanbaharum.retrofittutorial.model.GitModel;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by piracyde25 on 5/8/2015.
 */
public class ApiManager {
    public interface GitApi {
        @GET("/users/{user}")
        void getFeed(@Path("user") String user, Callback<GitModel> response);
        // string user is for passing values from edittext
        // response is the response from the server
    }

    private static final String API_URL = "https://api.github.com";

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();

    private static final GitApi GIT_API = REST_ADAPTER.create(GitApi.class);

    public static GitApi getService() {
        return GIT_API;
    }
}
