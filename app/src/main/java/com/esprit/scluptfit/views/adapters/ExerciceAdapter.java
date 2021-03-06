package com.esprit.scluptfit.views.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Exercice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciceAdapter extends RecyclerView.Adapter<ExerciceAdapter.ExerciceViewHolder> {
    private Context context;
    private ArrayList<Exercice> exerciceArrayList;

    public ExerciceAdapter(Context context, ArrayList<Exercice> exerciceArrayList) {
        this.context = context;
        this.exerciceArrayList = exerciceArrayList;
    }

    @NonNull
    @Override
    public ExerciceAdapter.ExerciceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercices, parent, false);
        return new ExerciceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciceAdapter.ExerciceViewHolder holder, int position) {

        Exercice exercice = exerciceArrayList.get(position);
        holder.descriptionExerciceTextView.setText(exercice.getDescription());
        holder.nameExerciceTextView.setText(exercice.getName());
       /*Picasso.get()
                .load(exercice.getImage())
                .fit().centerCrop()
                .into(holder.exerciceImageView);*/
        Glide.with(context).load(exercice.getImage()).into(holder.exerciceImageView);
    }

    @Override
    public int getItemCount() {
        return exerciceArrayList.size();
    }

    public class ExerciceViewHolder extends RecyclerView.ViewHolder {
        private ImageView exerciceImageView;
        private TextView nameExerciceTextView;
        private TextView descriptionExerciceTextView;
        public ExerciceViewHolder(@NonNull View itemView) {
            super(itemView);
            nameExerciceTextView = itemView.findViewById(R.id.nameExerciceTextView);
            descriptionExerciceTextView = itemView.findViewById(R.id.descriptionExerciceTextView);
            exerciceImageView = itemView.findViewById(R.id.exerciceImageView);
        }
    }
}
