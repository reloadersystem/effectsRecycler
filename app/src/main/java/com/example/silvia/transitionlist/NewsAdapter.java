package com.example.silvia.transitionlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    Context mContext;
    List<NewsItems> mData;

    public NewsAdapter(Context mContext, List<NewsItems> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout;
        layout= LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {

        newsViewHolder.tv_title.setText(mData.get(position).getTitle());
        newsViewHolder.tv_content.setText(mData.get(position).getContent());
        newsViewHolder.tv_date.setText(mData.get(position).getDate());
        newsViewHolder.img_user.setImageResource(mData.get(position).getUserPhoto());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_title, tv_content, tv_date;
        ImageView img_user;


        public NewsViewHolder(View itemView) {
            super(itemView);

            tv_title= itemView.findViewById(R.id.tv_title);
            tv_content= itemView.findViewById(R.id.tv_description);
            tv_date= itemView.findViewById(R.id.tv_date);
            img_user= itemView.findViewById(R.id.img_user);

        }
    }
}
