package com.example.retrofitexample1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Movie> movieList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);

         recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerAdapter=new RecyclerAdapter(getApplicationContext(), movieList);
        recyclerView.setAdapter(recyclerAdapter);

        // Call class of retrofit
        ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Call<List<Movie>> call=apiInterface.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList=response.body();
                Log.d("TAG", "Response ="+movieList);
                recyclerAdapter.setMovieList(movieList);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                 Log.d("TAG","Response ="+t.toString());
            }
        });


    }
}