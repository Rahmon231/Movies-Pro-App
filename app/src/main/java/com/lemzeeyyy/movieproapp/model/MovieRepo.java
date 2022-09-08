package com.lemzeeyyy.movieproapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MovieRepo {
    private ArrayList<Movie> movies = new ArrayList<>();
    MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application ;

    public MovieRepo(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {

        return mutableLiveData;
    }
}
