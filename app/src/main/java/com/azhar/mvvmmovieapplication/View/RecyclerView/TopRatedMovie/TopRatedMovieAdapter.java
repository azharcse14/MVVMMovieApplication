package com.azhar.mvvmmovieapplication.View.RecyclerView.TopRatedMovie;

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

public class TopRatedMovieAdapter extends RecyclerView.Adapter<TopRatedMovieViewHolder> {

    Context context;
    List<TopMovieResult> topMovieResultList;

    public TopRatedMovieAdapter(Context context, List<TopMovieResult> topMovieResultList) {
        this.context = context;
        this.topMovieResultList = topMovieResultList;
    }


    @NonNull
    @Override
    public TopRatedMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_movie_child, parent, false);

        TopRatedMovieViewHolder topRatedMovieViewHolder = new TopRatedMovieViewHolder(view);

        return topRatedMovieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopRatedMovieViewHolder holder, int position) {

        Glide.with(context).load("https://image.tmdb.org/t/p/original"+ topMovieResultList.get(position).getPosterPath()).into(holder.posterImgV);
        holder.titleTv.setText(topMovieResultList.get(position).getTitle());
        holder.ratingTv.setText(topMovieResultList.get(position).getVoteAverage().toString());
        holder.releaseDateTv.setText(topMovieResultList.get(position).getReleaseDate());

    }

    @Override
    public int getItemCount() {

        if (this.topMovieResultList != null){
            return topMovieResultList.size();
        }else {
            return 0;
        }
    }
}
