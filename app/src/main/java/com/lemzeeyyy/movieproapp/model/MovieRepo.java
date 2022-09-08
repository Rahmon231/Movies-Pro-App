package com.lemzeeyyy.movieproapp.model;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.lemzeeyyy.movieproapp.R;
import com.lemzeeyyy.movieproapp.service.MovieDataService;
import com.lemzeeyyy.movieproapp.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepo {
    private ArrayList<Movie> movies = new ArrayList<>();
    MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application ;

    public MovieRepo(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieDataService movieDataService = RetrofitInstance.getService();
        Call<Result> call = movieDataService.getPopularMovies(
                application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result!=null && result.getResults()!=null){
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), ""+t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });


        return mutableLiveData;
    }
}
