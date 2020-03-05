package com.yunwoon.prography;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {

    private ArrayList<RecyclerModel> recyclerModels = new ArrayList<>();

    public RecyclerAdaptor(ArrayList<RecyclerModel> recyclerModels){
        this.recyclerModels = recyclerModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleritem,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.num.setText((position+1)+"");
        holder.title.setText(recyclerModels.get(position).getTitle());
        holder.director.setText(recyclerModels.get(position).getDirector());
        holder.release_date.setText(recyclerModels.get(position).getRelease_date());
    }

    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView num, title, director, release_date;

        public ViewHolder(final View view){
            super(view);

            num = view.findViewById(R.id.num);
            title = view.findViewById(R.id.title);
            director = view.findViewById(R.id.director);
            release_date = view.findViewById(R.id.release_date);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //클릭 하면 !
                }
            });
        }
    }
}
