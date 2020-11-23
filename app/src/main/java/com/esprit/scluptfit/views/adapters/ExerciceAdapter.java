package com.esprit.scluptfit.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Exercice;

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
    }

    @Override
    public int getItemCount() {
        return exerciceArrayList.size();
    }

    public class ExerciceViewHolder extends RecyclerView.ViewHolder {
        private TextView nameExerciceTextView;
        private TextView descriptionExerciceTextView;
        public ExerciceViewHolder(@NonNull View itemView) {
            super(itemView);
            nameExerciceTextView = itemView.findViewById(R.id.nameExerciceTextView);
            descriptionExerciceTextView = itemView.findViewById(R.id.descriptionExerciceTextView);
        }
    }
}
