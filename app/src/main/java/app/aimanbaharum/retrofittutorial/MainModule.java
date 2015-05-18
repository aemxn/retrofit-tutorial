package app.aimanbaharum.retrofittutorial;

import javax.inject.Singleton;

import app.aimanbaharum.retrofittutorial.api.Github;
import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by piracyde25 on 5/17/2015.
 */
@Module(
        library = true,
        injects = {MainActivity.class}
)
public class MainModule {

    @Provides
    @Singleton
    Github buildGithubRestClient() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        return adapter.create(Github.class);
    }
}
