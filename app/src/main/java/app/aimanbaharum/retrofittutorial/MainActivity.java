package app.aimanbaharum.retrofittutorial;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import app.aimanbaharum.retrofittutorial.api.Github;
import app.aimanbaharum.retrofittutorial.loader.Callback;
import app.aimanbaharum.retrofittutorial.loader.RetrofitLoader;
import app.aimanbaharum.retrofittutorial.loader.RetrofitLoaderManager;
import app.aimanbaharum.retrofittutorial.model.GitModel;


public class MainActivity extends AppCompatActivity implements Callback<GitModel> {

    @Inject
    Github githubService;

    @Override
    public void onFailure(Exception ex) {
        setProgressBarIndeterminateVisibility(false);

        Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(GitModel result) {
        Log.d("User loader", "onSuccess");

        displayResults(result);

    }

    private void displayResults(GitModel result) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App)getApplication()).inject(this);

        setContentView(R.layout.activity_main);

        UserLoader loader = new UserLoader(this, githubService);
        RetrofitLoaderManager.init(getLoaderManager(), 0, loader, this);
    }

    static class UserLoader extends RetrofitLoader<GitModel, Github> {

        public UserLoader(Context context, Github service) {
            super(context, service);
        }

        @Override
        public GitModel call(Github service) {
            Log.d("UserLoader", "call");

            return service.getFeed("aimanbaharum");
        }


    }
}
