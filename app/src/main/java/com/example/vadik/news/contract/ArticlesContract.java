package com.example.vadik.news.contract;

import com.example.vadik.news.model.Article;

import java.util.List;

/**
 * Created by vadik on 08.12.16.
 */

public interface ArticlesContract {

    interface View extends BaseContract.View {

        void showArticles(List<Article> articles);

    }

    interface Presenter extends BaseContract.Presenter<View> {

        void fetchArticles(String sourceId);

    }

}
