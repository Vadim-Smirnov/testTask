package com.example.vadik.news.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.vadik.news.R;
import com.example.vadik.news.contract.SourcesContract;
import com.example.vadik.news.model.Source;
import com.example.vadik.news.presenter.SourcesPresenter;
import com.example.vadik.news.view.adapter.SourcesListAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class SourcesFragment extends Fragment implements SourcesContract.View {

    private SourcesContract.Presenter mPresenter;

    private SourcesListAdapter mSourcesListAdapter;

    @Bind(R.id.list_view_sources)
    protected ListView mListViewSources;

    @Bind(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    public static SourcesFragment newInstance() {
        return new SourcesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sources, container, false);

        ButterKnife.bind(this, view);
        mPresenter = new SourcesPresenter();
        mPresenter.attachView(this);
        mPresenter.fetchSources();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void showSources(List<Source> sources) {
        mSourcesListAdapter = new SourcesListAdapter(sources);
        mListViewSources.setAdapter(mSourcesListAdapter);
    }

    @Override
    public void showLoading(boolean isShow) {
        mListViewSources.setVisibility(isShow ? View.GONE : View.VISIBLE);
        mProgressBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @OnItemClick(R.id.list_view_sources)
    public void onSourceClick(int position) {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("")
                .replace(R.id.fragments_container, ArticlesFragment
                        .newInstance(mSourcesListAdapter.getItem(position).getId()))
                .commitAllowingStateLoss();
    }
}
