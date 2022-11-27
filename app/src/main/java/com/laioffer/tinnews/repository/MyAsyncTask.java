package com.laioffer.tinnews.repository;

import android.os.Handler;
import android.os.Looper;

import com.laioffer.tinnews.model.Article;


public abstract class MyAsyncTask<Params, Progress, Result> {
    //向mainthread发送信息
    private Handler handler = new Handler(Looper.getMainLooper());

    protected abstract Result doInBackground(Params params);

    protected void onPreExecute() {

    }
    protected void publishProgress(final Progress progress) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onProgressUpdate(progress);
            }
        });
    }

    protected void onProgressUpdate(Progress progress) {

    }

    protected void onPostExecute(Result result) {

    }

    public MyAsyncTask<Params, Progress, Result> execute(final Params params) {
        onPreExecute();
        //do in the new background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                Result result = doInBackground(params);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onPostExecute(result);
                    }
                });
            }
        }).start();
        return this;
    }

    public static void execute(Runnable runnable) {
        new MyAsyncTask() {
            @Override
            protected Object doInBackground(Object o) {
                runnable.run();
                return null;
            }
        };
    }


    public void main() {
        new MyFavoriteAsyncTask().execute(new Article());
        MyAsyncTask.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public static class MyFavoriteAsyncTask extends MyAsyncTask<Article, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Article article) {
            return null;
        }
    }
}
