package com.azhar.mvvmmovieapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.azhar.mvvmmovieapplication.Model.DataModel.TopMovie.TopMovieResult;
import com.azhar.mvvmmovieapplication.Model.Repository.MovieRepository;

import java.util.List;

public class TopMovieListViewModel extends AndroidViewModel {

    private final MovieRepository movieRepository;

    public TopMovieListViewModel(@NonNull Application application) {
        super(application);
        movieRepository = MovieRepository.getInstance(application);
    }

    public LiveData<List<TopMovieResult>> getTopRatedMovieLists(){
        return movieRepository.getTopRatedMovieLists();
    }
}
