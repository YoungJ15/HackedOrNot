package com.solutions.jpd.apps.hackedornot.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.NativeExpressAdView;
import com.solutions.jpd.apps.hackedornot.DetailsActivity;
import com.solutions.jpd.apps.hackedornot.R;
import com.solutions.jpd.apps.hackedornot.model.HackedList;
import com.solutions.jpd.apps.hackedornot.model.HackedSource;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josermando Peralta on 10/26/2016.
 */
public class MyHackedDataAdapter extends RecyclerView.Adapter<MyHackedDataAdapter.ViewHolder> {

    private List<HackedSource> hackedSourceList;
    private static final int VIEW_TYPE_EMPTY_PLACEHOLDER = 0;
    private static final int VIEW_TYPE_OBJECT_VIEW = 1;
    private Context context;

    public MyHackedDataAdapter(List<HackedSource> source){
        this.hackedSourceList = source;
    }

    @Override
    public int getItemViewType(int position) {
        if(hackedSourceList.isEmpty()){
            return VIEW_TYPE_EMPTY_PLACEHOLDER;
        }
        else{
            return VIEW_TYPE_OBJECT_VIEW;
        }
    }

    @Override
    public MyHackedDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case VIEW_TYPE_OBJECT_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
                break;
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHackedDataAdapter.ViewHolder holder, final int position) {
        holder.title_tv.setText(hackedSourceList.get(position).getTitle());
        holder.author_tv.setText(hackedSourceList.get(position).getAuthor());
        holder.verified_tv.setText(hackedSourceList.get(position).getIsVrf().toString());
        holder.date_created_tv.setText(hackedSourceList.get(position).getDateCreated());
        holder.date_leaked_tv.setText(hackedSourceList.get(position).getDateLeaked());
        holder.network_tv.setText(hackedSourceList.get(position).getSourceNetwork());
        holder.url_tv.setText(hackedSourceList.get(position).getSourceUrl());
        holder.provider_tv.setText(hackedSourceList.get(position).getSourceProvider());
        context = holder.logoView.getContext();
        String title = splitString(hackedSourceList.get(position).getTitle());
        String clearBit = "http://logo.clearbit.com/";
        Picasso.with(context).load(clearBit+title).error(R.mipmap.ic_launcher).into(holder.logoView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtra("POSITION", String.valueOf(position));
                intent.putExtra("HACKED_LIST", (Serializable) hackedSourceList);
                v.getContext().startActivity(intent);
            }
        });
    }



    private String splitString(String source){
        String word = null;
        if(source.contains(" ")){
            word = source.substring(0, source.indexOf(" "));

            if(word.contains(".")){
                word = word+"";
            }
            if(!word.contains(".com")){
                word = word + ".com";
            }

        }
        else{
            word = source;
            if(word.contains(".")){
                word = word+"";
            }
            if(!word.contains(".com") & !word.contains(".fm")){
                word = word + ".com";
            }
        }
        return word;
    }

    @Override
    public int getItemCount() {
        return hackedSourceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title_tv, author_tv, verified_tv,date_created_tv,date_leaked_tv,network_tv,url_tv,provider_tv;
        private ImageView logoView;
        private CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            title_tv = (TextView) itemView.findViewById(R.id.title_tv);
            author_tv = (TextView) itemView.findViewById(R.id.author_tv);
            verified_tv = (TextView) itemView.findViewById(R.id.verified_tv);
            date_created_tv = (TextView) itemView.findViewById(R.id.date_created_tv);
            date_leaked_tv = (TextView) itemView.findViewById(R.id.date_leaked_tv);
            network_tv = (TextView) itemView.findViewById(R.id.network_tv);
            url_tv = (TextView) itemView.findViewById(R.id.url_tv);
            provider_tv = (TextView) itemView.findViewById(R.id.provider_tv);
            logoView = (ImageView) itemView.findViewById(R.id.logo_view);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}
