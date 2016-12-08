package com.example.vadik.news.view.adapter.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vadik.news.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by vadik on 09.12.16.
 */

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private View mArticleView;

    @Bind(R.id.image_view_article)
    protected ImageView mImageViewArticle;

    @Bind(R.id.text_view_title)
    protected TextView mTextViewTitle;

    @Bind(R.id.text_view_description)
    protected TextView mTextViewDescription;

    @Bind(R.id.text_view_date)
    protected TextView mTextViewDate;

    public ImageView getImageViewArticle() {
        return mImageViewArticle;
    }

    public TextView getTextViewTitle() {
        return mTextViewTitle;
    }

    public TextView getTextViewDescription() {
        return mTextViewDescription;
    }

    public TextView getTextViewDate() {
        return mTextViewDate;
    }

    public ArticleViewHolder(View itemView) {
        super(itemView);
        mArticleView = itemView;
        ButterKnife.bind(this, mArticleView);
    }
}
