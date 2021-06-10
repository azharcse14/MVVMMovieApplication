package com.azhar.mvvmmovieapplication.View.RecyclerView.PopularMovie;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.mvvmmovieapplication.R;

public class PopularMovieViewHolder extends RecyclerView.ViewHolder {

    ImageView posterImgV;
    TextView titleTv, ratingTv, releaseDateTv;

    public PopularMovieViewHolder(@NonNull View itemView) {
        super(itemView);

        posterImgV = itemView.findViewById(R.id.posterImgV);
        titleTv = itemView.findViewById(R.id.titleTvId);
        ratingTv = itemView.findViewById(R.id.ratingTvId);
        releaseDateTv = itemView.findViewById(R.id.releaseDateTvId);
    }
}
