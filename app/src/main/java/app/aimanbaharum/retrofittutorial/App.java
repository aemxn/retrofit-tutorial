package app.aimanbaharum.retrofittutorial;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by piracyde25 on 5/17/2015.
 */
public class App extends Application {

    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(MainModule.class);
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
