package com.example.vadik.news.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.vadik.news.R;
import com.example.vadik.news.contract.ArticlesContract;
import com.example.vadik.news.model.Article;
import com.example.vadik.news.presenter.ArticlesPresenter;
import com.example.vadik.news.view.adapter.ArticlesRecyclerAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ArticlesFragment extends Fragment implements ArticlesContract.View {

    private static String SOURCE_ID_ARG = "source_id";

    private ArticlesContract.Presenter mPresenter;

    private ArticlesRecyclerAdapter mArticlesRecyclerAdapter;

    private String mSelectedSource;

    @Bind(R.id.recycler_view_articles)
    protected RecyclerView mRecyclerViewArticles;



    @Bind(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    public static ArticlesFragment newInstance(String sourceId) {
        ArticlesFragment fragment = new ArticlesFragment();
        Bundle arguments = new Bundle();
        arguments.putString(SOURCE_ID_ARG, sourceId);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle receiveArguments = getArguments();
        if (receiveArguments != null) {
            mSelectedSource = receiveArguments.getString(SOURCE_ID_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);

        ButterKnife.bind(this, view);
        mPresenter = new ArticlesPresenter();
        mPresenter.attachView(this);
        mPresenter.fetchArticles(mSelectedSource);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void showLoading(boolean isShow) {
        mRecyclerViewArticles.setVisibility(isShow ? View.GONE : View.VISIBLE);
        mProgressBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showArticles(List<Article> articles) {
        LinearLayoutManager recyclerLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerViewArticles.setLayoutManager(recyclerLayoutManager);
        mRecyclerViewArticles.setHasFixedSize(true);

        mArticlesRecyclerAdapter = new ArticlesRecyclerAdapter(getContext(), articles);
        mRecyclerViewArticles.setAdapter(mArticlesRecyclerAdapter);
    }
}
