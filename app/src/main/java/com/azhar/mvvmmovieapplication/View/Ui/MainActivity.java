package com.azhar.mvvmmovieapplication.View.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.azhar.mvvmmovieapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToTopRat(View view) {
        startActivity(new Intent(getApplicationContext(), TopRatMovieActivity.class));
    }

    public void goToTopPopular(View view) {
        startActivity(new Intent(getApplicationContext(), PopularMovieActivity.class));

    }
}