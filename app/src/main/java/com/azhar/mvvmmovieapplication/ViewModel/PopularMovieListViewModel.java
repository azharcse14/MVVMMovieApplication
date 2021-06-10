package com.azhar.mvvmmovieapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.azhar.mvvmmovieapplication.Model.DataModel.PopularMovie.PopularMovieResult;
import com.azhar.mvvmmovieapplication.Model.Repository.MovieRepository;

import java.util.List;

public class PopularMovieListViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public PopularMovieListViewModel(@NonNull Application application) {
        super(application);
        movieRepository = MovieRepository.getInstance(application);
    }

    public LiveData<List<PopularMovieResult>> getPopulerMovieLists(){
        return movieRepository.getPopularMovieLists();
    }
}
