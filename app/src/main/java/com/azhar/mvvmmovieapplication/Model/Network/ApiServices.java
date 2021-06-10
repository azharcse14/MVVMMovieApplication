package com.azhar.mvvmmovieapplication.Model.Network;

import com.azhar.mvvmmovieapplication.Model.DataModel.PopularMovie.PopularMovieModel;
import com.azhar.mvvmmovieapplication.Model.DataModel.TopMovie.TopMovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("3/movie/top_rated?api_key=48cb9509a001c7ba3f702ee13a8baa68")
    Call<TopMovieModel> getTopRatedMovieLists();

    @GET("3/movie/popular?api_key=48cb9509a001c7ba3f702ee13a8baa68")
    Call<PopularMovieModel> getPopularMovieLists();
}
