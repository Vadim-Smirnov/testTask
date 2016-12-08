package com.example.vadik.news.api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vadik on 08.12.16.
 */

public interface NewsApi {

    @GET(ApiConstants.SOURCES_URL)
    Call<JsonElement> fetchSources();

    @GET(ApiConstants.ARTICLES_URL)
    Call<JsonElement> fetchArticles(@Query("source") String sourceId, @Query("apiKey") String key);

}
