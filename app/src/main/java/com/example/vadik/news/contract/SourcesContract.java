package com.example.vadik.news.contract;

import com.example.vadik.news.model.Source;

import java.util.List;

/**
 * Created by vadik on 08.12.16.
 */

public interface SourcesContract {

    interface View extends BaseContract.View {

        void showSources(List<Source> sources);

    }

    interface Presenter extends BaseContract.Presenter<View> {

        void fetchSources();

    }

}
