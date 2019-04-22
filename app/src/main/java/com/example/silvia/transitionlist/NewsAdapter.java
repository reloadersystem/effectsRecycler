package com.example.silvia.transitionlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>
        implements View.OnClickListener

{


    Context mContext;
    List<NewsItems> mData;

    private View.OnClickListener listener;

    public NewsAdapter(Context mContext, List<NewsItems> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);

        //escuchador  de click

        layout.setOnClickListener(this);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {

        //we apply animation to view here
        //first  lets create  an animation userfoto
//efecto  solo imagen
        newsViewHolder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));

        //let's create the animation for  the  whole  card
        //first lets create a reference to it
        //you can  use the previous animation like  the  following
//efecto  union foto  mas  celda salida  izquierda a derecha
        /* newsViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));*/
// probamos solo escalar
        newsViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

        newsViewHolder.tv_title.setText(mData.get(position).getTitle());
        newsViewHolder.tv_content.setText(mData.get(position).getContent());
        newsViewHolder.tv_date.setText(mData.get(position).getDate());
        newsViewHolder.img_user.setImageResource(mData.get(position).getUserPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //metodo para  click listener

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {

        //validacion click listener

        if (listener != null) {
            listener.onClick(view);
        }
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_content, tv_date;
        ImageView img_user;

        //referencia

        RelativeLayout container;


        public NewsViewHolder(View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.action_container);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_description);
            tv_date = itemView.findViewById(R.id.tv_date);
            img_user = itemView.findViewById(R.id.img_user);

        }
    }
}
