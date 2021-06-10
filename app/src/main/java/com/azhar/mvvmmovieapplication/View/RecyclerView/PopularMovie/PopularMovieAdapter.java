package com.azhar.mvvmmovieapplication.View.RecyclerView.PopularMovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.mvvmmovieapplication.Model.DataModel.PopularMovie.PopularMovieResult;
import com.azhar.mvvmmovieapplication.Model.DataModel.TopMovie.TopMovieResult;
import com.azhar.mvvmmovieapplication.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieViewHolder> {

    Context context;
    List<PopularMovieResult> popularMovieResultList;

    public PopularMovieAdapter(Context context, List<PopularMovieResult> popularMovieResultList) {
        this.context = context;
        this.popularMovieResultList = popularMovieResultList;
    }

    @NonNull
    @Override
    public PopularMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_movie_child, parent, false);

        PopularMovieViewHolder popularMovieViewHolder = new PopularMovieViewHolder(view);

        return popularMovieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMovieViewHolder holder, int position) {

        Glide.with(context).load("https://image.tmdb.org/t/p/original"+ popularMovieResultList.get(position).getPosterPath()).into(holder.posterImgV);
        holder.titleTv.setText(popularMovieResultList.get(position).getTitle());
        holder.ratingTv.setText(popularMovieResultList.get(position).getVoteAverage().toString());
        holder.releaseDateTv.setText(popularMovieResultList.get(position).getReleaseDate());

    }

    @Override
    public int getItemCount() {

        if (this.popularMovieResultList != null){
            return popularMovieResultList.size();
        }else {
            return 0;
        }
    }
}
