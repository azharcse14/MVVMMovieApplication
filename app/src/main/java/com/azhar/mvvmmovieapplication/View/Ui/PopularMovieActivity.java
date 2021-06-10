package com.azhar.mvvmmovieapplication.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.azhar.mvvmmovieapplication.Model.DataModel.PopularMovie.PopularMovieResult;
import com.azhar.mvvmmovieapplication.R;
import com.azhar.mvvmmovieapplication.View.RecyclerView.PopularMovie.PopularMovieAdapter;
import com.azhar.mvvmmovieapplication.View.RecyclerView.TopRatedMovie.TopRatedMovieAdapter;
import com.azhar.mvvmmovieapplication.ViewModel.PopularMovieListViewModel;
import com.azhar.mvvmmovieapplication.ViewModel.TopMovieListViewModel;

import java.util.List;

public class PopularMovieActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PopularMovieListViewModel popularMovieListViewModel;
    PopularMovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movie);

        recyclerView = findViewById(R.id.recyclerViewId);
        popularMovieListViewModel = new ViewModelProvider(this).get(PopularMovieListViewModel.class);
        popularMovieListViewModel.getPopulerMovieLists().observe(this, new Observer<List<PopularMovieResult>>() {
            @Override
            public void onChanged(List<PopularMovieResult> popularMovieResults) {
                adapter = new PopularMovieAdapter(PopularMovieActivity.this, popularMovieResults);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}