package com.yunwoon.prography;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerAdaptor adaptor;
    private ArrayList<RecyclerModel> data = new ArrayList<>();
    public static final String BASE_URL = "https://ghibliapi.herokuapp.com";
    private Gson gson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adaptor = new RecyclerAdaptor(data);
        recyclerView.setAdapter(adaptor);
        getGson();
        return view;
    }

    public void getGson(){
        RetrofitClient<RestInterface> client;
        RestInterface restInterface;

        client = new RetrofitClient<>();
        restInterface = client.getClient(RestInterface.class);

        Call<List<RecyclerModel>> call = restInterface.getRecyclerList();
        call.enqueue(new Callback<List<RecyclerModel>>() {
            @Override
            public void onResponse(Call<List<RecyclerModel>> call, Response<List<RecyclerModel>> response) {
                data.clear();
                List<RecyclerModel> modelList = response.body();
                data.addAll(modelList);
                adaptor = new RecyclerAdaptor(data);
                recyclerView.setAdapter(adaptor);
                adaptor.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<RecyclerModel>> call, Throwable t) {
                Toast.makeText(getContext(),"호출 실패",Toast.LENGTH_SHORT).show();
                Log.d("Error", t.getMessage());
            }
        });
    }
}