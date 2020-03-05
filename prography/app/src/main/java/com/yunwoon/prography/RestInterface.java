package com.yunwoon.prography;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {
    @GET("/films")
    Call<List<RecyclerModel>> getRecyclerList();
}
