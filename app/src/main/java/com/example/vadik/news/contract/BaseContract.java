package com.example.vadik.news.contract;

import android.content.Context;

/**
 * Created by vadik on 08.12.16.
 */

public interface BaseContract {

    interface View {

        Context getContext();

        void showLoading(boolean isShow);

        void showError(String message);

    }

    interface Presenter <V extends View> {

        void attachView(V view);

        void detachView();

    }

}
