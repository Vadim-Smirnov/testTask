package com.example.vadik.news.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vadik.news.R;
import com.example.vadik.news.model.Source;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by vadik on 08.12.16.
 */

public class SourcesListAdapter extends BaseAdapter{

    private List<Source> mSources;

    public SourcesListAdapter(List<Source> sources) {
        mSources = sources;
    }

    @Override
    public int getCount() {
        return mSources.size();
    }

    @Override
    public Source getItem(int i) {
        return mSources.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View sourceView = view;
        if (sourceView == null) {
            sourceView = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.list_item_source, viewGroup, false);
        }

        TextView textViewSourceName = ButterKnife.findById(sourceView, R.id.text_view_source_name);
        textViewSourceName.setText(mSources.get(i).getName());

        return sourceView;
    }
}
