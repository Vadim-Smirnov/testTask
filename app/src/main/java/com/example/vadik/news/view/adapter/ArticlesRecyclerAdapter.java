package com.example.vadik.news.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.vadik.news.R;
import com.example.vadik.news.model.Article;
import com.example.vadik.news.view.adapter.view_holder.ArticleViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vadik on 09.12.16.
 */

public class ArticlesRecyclerAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private Context mContext;
    private List<Article> mArticles;

    public ArticlesRecyclerAdapter(Context context, List<Article> articles) {
        mContext = context;
        mArticles = articles;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View articleItemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_article, parent, false);
        return new ArticleViewHolder(articleItemView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article currentArticle = mArticles.get(position);

        holder.getTextViewTitle().setText(currentArticle.getTitle());
        holder.getTextViewDescription().setText(currentArticle.getDescription());
        holder.getTextViewDate().setText(currentArticle.getPublishedAt());
        Picasso.with(mContext)
                .load(currentArticle.getUrlToImage())
                .into(holder.getImageViewArticle());
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}
