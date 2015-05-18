package app.aimanbaharum.retrofittutorial.loader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

/**
 * Created by piracyde25 on 5/18/2015.
 */
public class RetrofitLoaderManager {

    public static <D, R> void init(final LoaderManager manager, final int loaderId,
                                   final RetrofitLoader<D, R> loader, final Callback<D> callback) {

        manager.initLoader(loaderId, Bundle.EMPTY, new LoaderManager.LoaderCallbacks<Response<D>>() {
            @Override
            public Loader<Response<D>> onCreateLoader(int id, Bundle args) {
                return loader;
            }

            @Override
            public void onLoadFinished(Loader<Response<D>> loader, Response<D> data) {
                if (data.hasError()) {
                    callback.onFailure(data.getException());
                } else {
                    callback.onSuccess(data.getResult());
                }
            }

            @Override
            public void onLoaderReset(Loader<Response<D>> loader) {

            }
        });
    }
}
