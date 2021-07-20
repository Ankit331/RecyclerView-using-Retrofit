package com.example.retrofitexample1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofitexample1.R;
import com.example.retrofitexample1.model.Movie;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {

    Context context;
    List<Movie> movieList;

    public RecyclerAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieList(List<Movie> movieList)
    {
        this.movieList=movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
     holder.tvMovieName.setText(movieList.get(position).getTitle());
        Glide.with(context).
                load(movieList.get(position).getImage()).
                apply(RequestOptions.centerCropTransform()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        if(movieList !=null){
            return movieList.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
         TextView tvMovieName;
         ImageView image;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieName=itemView.findViewById(R.id.movietitle);
            image=itemView.findViewById(R.id.movieimage);
        }
    }
}
