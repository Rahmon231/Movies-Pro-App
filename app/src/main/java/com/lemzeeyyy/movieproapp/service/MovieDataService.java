package com.lemzeeyyy.movieproapp.service;

import com.lemzeeyyy.movieproapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {

    //End_Point Url
    //movie/popular?api_key=528aa63374c88d874c52737b28bfafb9
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);
}
