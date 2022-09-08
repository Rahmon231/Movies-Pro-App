package com.lemzeeyyy.movieproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.lemzeeyyy.movieproapp.databinding.ActivityMovieDetailsBinding;
import com.lemzeeyyy.movieproapp.model.Movie;

public class MovieDetailsActivity extends AppCompatActivity {
    private Movie movie;
    private ActivityMovieDetailsBinding movieDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movieDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie_details);
        Intent intent = getIntent();
        if(intent!=null){
            movie = getIntent().getParcelableExtra("movie");
            movieDetailsBinding.setMovie(movie);
            getSupportActionBar().setTitle(movie.getTitle());
        }
    }
}