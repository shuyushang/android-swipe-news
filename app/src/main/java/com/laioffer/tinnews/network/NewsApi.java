package com.laioffer.tinnews.network;

import com.laioffer.tinnews.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//retrofit
public interface NewsApi {
    //interface不用实现，告诉retrofit，我的request长什么样子

    //get topheadlines
    //baseUrl/topheadlines?q=tesla&country=us
    @GET("top-headlines")
    Call<NewsResponse> getTopHeadLines(@Query("country") String country);

   //baseUrl/everything?q=tesla&pageSize=3
    @GET("everything")
    Call<NewsResponse> getEverything(@Query("q") String query, @Query("pageSize") int pageSize);
}
