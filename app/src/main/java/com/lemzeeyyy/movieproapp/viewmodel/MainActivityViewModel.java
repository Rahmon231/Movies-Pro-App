package com.lemzeeyyy.movieproapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lemzeeyyy.movieproapp.model.Movie;
import com.lemzeeyyy.movieproapp.model.MovieRepo;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MovieRepo movieRepo;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        movieRepo = new MovieRepo(application);
    }

    public LiveData<List<Movie>> getAllMovies(){
        return movieRepo.getMutableLiveData();
    }
}
