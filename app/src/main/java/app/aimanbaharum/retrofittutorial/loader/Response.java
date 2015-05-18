package app.aimanbaharum.retrofittutorial.loader;

/**
 * Created by piracyde25 on 5/18/2015.
 */
class Response<D> {

    private Exception mException;

    private D mResult;

    static <D> Response<D> ok(D data) {
        Response<D> response = new Response<D>();
        response.mResult = data;

        return response;
    }

    static <D> Response<D> error(Exception ex) {
        Response<D> response = new Response<D>();
        response.mException = ex;

        return response;
    }

    public boolean hasError() {
        return mException != null;
    }

    public Exception getException() {
        return mException;
    }

    public D getResult() {
        return mResult;
    }
}
