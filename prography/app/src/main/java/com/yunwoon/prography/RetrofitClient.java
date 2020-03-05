package com.yunwoon.prography;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//BASE_URL 설정 , OkHttp 및 데이터를 파싱 GsonConverter 지정함
public class RetrofitClient<T> {
    public static final String BASE_URL = "https://ghibliapi.herokuapp.com";
    private T service;

    public T getClient(Class<? extends T> type){
        if(service == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder().header("ex-hader","sample")
                            .method(original.method(), original.body()).build();
                    return chain.proceed(request);
                }
            }).build();
            Retrofit client = new Retrofit.Builder().baseUrl(BASE_URL)
                    .client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            service = client.create(type);
        }
        return service;
    }
}