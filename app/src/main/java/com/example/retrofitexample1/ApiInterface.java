package com.example.retrofitexample1;

import com.example.retrofitexample1.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/b/609d112086baa063065e3600/3")
    Call<List<Movie>> getMovies();
}

