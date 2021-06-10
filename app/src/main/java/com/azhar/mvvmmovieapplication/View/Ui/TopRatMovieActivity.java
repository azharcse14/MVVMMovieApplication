package com.azhar.mvvmmovieapplication.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.azhar.mvvmmovieapplication.Model.DataModel.TopMovie.TopMovieResult;
import com.azhar.mvvmmovieapplication.R;
import com.azhar.mvvmmovieapplication.View.RecyclerView.TopRatedMovie.TopRatedMovieAdapter;
import com.azhar.mvvmmovieapplication.ViewModel.TopMovieListViewModel;

import java.util.List;

public class TopRatMovieActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TopMovieListViewModel topMovieListViewModel;
    TopRatedMovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_movie);

        recyclerView = findViewById(R.id.recyclerViewId);
        topMovieListViewModel = new ViewModelProvider(this).get(TopMovieListViewModel.class);
        topMovieListViewModel.getTopRatedMovieLists().observe(this, new Observer<List<TopMovieResult>>() {
            @Override
            public void onChanged(List<TopMovieResult> topMovieResults) {

                adapter = new TopRatedMovieAdapter(TopRatMovieActivity.this, topMovieResults);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}