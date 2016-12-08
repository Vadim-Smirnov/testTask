package com.example.vadik.news.presenter;

import android.util.Log;

import com.example.vadik.news.api.ApiConstants;
import com.example.vadik.news.api.NewsApi;
import com.example.vadik.news.contract.ArticlesContract;
import com.example.vadik.news.manager.ApiManager;
import com.example.vadik.news.model.Article;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vadik on 08.12.16.
 */

public class ArticlesPresenter implements ArticlesContract.Presenter {

    private ArticlesContract.View mView;

    @Override
    public void fetchArticles(String sourceId) {
        mView.showLoading(true);
        ApiManager
                .getInstance()
                .getService(NewsApi.class)
                .fetchArticles(sourceId, ApiConstants.API_KEY)
                .enqueue(new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        Article[] arrayArticles = new Gson().
                                fromJson(response
                                        .body()
                                        .getAsJsonObject()
                                        .get("articles"), Article[].class);
                        mView.showArticles(Arrays.asList(arrayArticles));
                        mView.showLoading(false);
                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {
                        t.printStackTrace();
                        mView.showError(t.getMessage());
                        mView.showLoading(false);
                    }
                });
    }

    @Override
    public void attachView(ArticlesContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
