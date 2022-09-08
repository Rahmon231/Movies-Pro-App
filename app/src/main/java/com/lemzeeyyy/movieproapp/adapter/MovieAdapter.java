package com.lemzeeyyy.movieproapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lemzeeyyy.movieproapp.MovieDetailsActivity;
import com.lemzeeyyy.movieproapp.R;
import com.lemzeeyyy.movieproapp.databinding.MovieItemLayoutBinding;
import com.lemzeeyyy.movieproapp.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemLayoutBinding movieItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater
                .from(context), R.layout.movie_item_layout,parent,false);
        return new MovieViewHolder(movieItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        holder.movieItemLayoutBinding.setMovie(movie);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private MovieItemLayoutBinding movieItemLayoutBinding;

        public MovieViewHolder(@NonNull MovieItemLayoutBinding movieItemLayoutBinding) {
            super(movieItemLayoutBinding.getRoot());
            this.movieItemLayoutBinding = movieItemLayoutBinding;
            movieItemLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Movie selectedMovie = movieArrayList.get(pos);
                        Intent intent = new Intent(context, MovieDetailsActivity.class);
                        intent.putExtra("movie",selectedMovie);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
