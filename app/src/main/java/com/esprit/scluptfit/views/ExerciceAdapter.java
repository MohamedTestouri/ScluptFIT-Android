package com.esprit.scluptfit.views;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Exercice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciceAdapter extends RecyclerView.Adapter<ExerciceAdapter.ExerciceViewHolder> {
    private ArrayList<Exercice> exerciceArrayList = new ArrayList<>();

    public ExerciceAdapter(ArrayList<Exercice> exerciceArrayList) {
        this.exerciceArrayList = exerciceArrayList;
    }

    @NonNull
    @Override
    public ExerciceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercices, parent, false);
        return new ExerciceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciceViewHolder holder, int position) {
        Exercice exercice = exerciceArrayList.get(position);
        holder.descriptionExerciceTextView.setText(exercice.getDescription());
        holder.nameExerciceTextView.setText(exercice.getName());
        Picasso.get()
                .load(Uri.parse(exercice.getImage()))
                .fit().centerCrop()
                .into(holder.exerciceImageView);

    }

    @Override
    public int getItemCount() {
        return exerciceArrayList.size();
    }

    public static class ExerciceViewHolder extends RecyclerView.ViewHolder {
        private final ImageView exerciceImageView;
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
