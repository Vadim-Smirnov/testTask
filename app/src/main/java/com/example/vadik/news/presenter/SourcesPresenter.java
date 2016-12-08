package com.example.vadik.news.presenter;

import com.example.vadik.news.api.NewsApi;
import com.example.vadik.news.contract.SourcesContract;
import com.example.vadik.news.manager.ApiManager;
import com.example.vadik.news.model.Source;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vadik on 08.12.16.
 */

public class SourcesPresenter implements SourcesContract.Presenter {

    private SourcesContract.View mView;

    @Override
    public void fetchSources() {
        mView.showLoading(true);

        ApiManager
                .getInstance()
                .getService(NewsApi.class)
                .fetchSources()
                .enqueue(new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        Source[] arraySource = new Gson()
                                .fromJson(response
                                        .body()
                                        .getAsJsonObject()
                                        .get("sources"), Source[].class);
                        mView.showSources(Arrays.asList(arraySource));
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
    public void attachView(SourcesContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
