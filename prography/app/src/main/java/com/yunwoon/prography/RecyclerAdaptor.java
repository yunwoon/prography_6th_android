package com.yunwoon.prography;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//RecyclerView 를 위한 Adaptor class
public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {

    private ArrayList<RecyclerModel> recyclerModels = new ArrayList<>();

    public RecyclerAdaptor(ArrayList<RecyclerModel> recyclerModels){
        this.recyclerModels = recyclerModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //row layout 을 화면에 뿌려주고 Holder 에 연결
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleritem,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) { //각 위치에 문자열 세팅
        holder.num.setText((position+1)+"");
        holder.title.setText(recyclerModels.get(position).getTitle());
        holder.director.setText(recyclerModels.get(position).getDirector());
        holder.release_date.setText(recyclerModels.get(position).getRelease_date());
    }

    @Override
    public int getItemCount() { //몇 개의 데이터를 리스트로 뿌려줘야 하는지 정의
        return recyclerModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{ //ViewHolder == 하나의 View 보존하는 역할
        public TextView num, title, director, release_date;

        public ViewHolder(final View view){
            super(view);

            num = view.findViewById(R.id.num);
            title = view.findViewById(R.id.title);
            director = view.findViewById(R.id.director);
            release_date = view.findViewById(R.id.release_date);

            view.setOnClickListener(new View.OnClickListener() { //하나의 View's 클릭 이벤트
                @Override
                public void onClick(View v) {
                    //클릭 하면 ! //맞네 여기
                    Toast.makeText(v.getContext(),"clicked",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
