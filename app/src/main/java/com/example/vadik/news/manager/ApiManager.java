package com.example.vadik.news.manager;

import android.content.Context;

import com.example.vadik.news.api.ApiConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vadik on 08.12.16.
 */

public class ApiManager {

    private static ApiManager sInstance;

    private Retrofit mRetrofit;

    private ApiManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiManager getInstance() {
        if (sInstance == null) {
            sInstance = new ApiManager();
        }
        return sInstance;
    }

    public <T> T getService(Class<T> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}
