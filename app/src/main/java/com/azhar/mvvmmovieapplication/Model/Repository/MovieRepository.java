package com.azhar.mvvmmovieapplication.Model.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.azhar.mvvmmovieapplication.Model.DataModel.PopularMovie.PopularMovieModel;
import com.azhar.mvvmmovieapplication.Model.DataModel.PopularMovie.PopularMovieResult;
import com.azhar.mvvmmovieapplication.Model.DataModel.TopMovie.TopMovieModel;
import com.azhar.mvvmmovieapplication.Model.DataModel.TopMovie.TopMovieResult;
import com.azhar.mvvmmovieapplication.Model.Network.ApiServices;
import com.azhar.mvvmmovieapplication.Model.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static Context mContext;
    private static MovieRepository instance;
    private TopMovieModel topMovieModel;
    private List<TopMovieResult> topMovieResultList;

    private PopularMovieModel popularMovieModel;
    private List<PopularMovieResult> popularMovieResultList;
    private MutableLiveData mutableLiveData;

    public static MovieRepository getInstance(Context context){
        if (instance == null){
            mContext = context;
            instance = new MovieRepository();
        }

        return instance;
    }

    public LiveData<List<TopMovieResult>> getTopRatedMovieLists(){

        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData();
        }

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        Call<TopMovieModel> call = apiServices.getTopRatedMovieLists();

        call.enqueue(new Callback<TopMovieModel>() {
            @Override
            public void onResponse(Call<TopMovieModel> call, Response<TopMovieModel> response) {

                topMovieModel = response.body();
                topMovieResultList = topMovieModel.getTopMovieResults();
                mutableLiveData.postValue(topMovieResultList);
            }

            @Override
            public void onFailure(Call<TopMovieModel> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }

    public LiveData<List<PopularMovieResult>> getPopularMovieLists(){

        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData();
        }

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        Call<PopularMovieModel> call = apiServices.getPopularMovieLists();

        call.enqueue(new Callback<PopularMovieModel>() {
            @Override
            public void onResponse(Call<PopularMovieModel> call, Response<PopularMovieModel> response) {

                popularMovieModel = response.body();
                popularMovieResultList = popularMovieModel.getPopularMovieResults();
                mutableLiveData.postValue(popularMovieResultList);
            }

            @Override
            public void onFailure(Call<PopularMovieModel> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
