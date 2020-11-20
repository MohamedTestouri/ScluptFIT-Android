package com.esprit.scluptfit.views;

import android.content.Context;
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
    private final Context myContext;
    private final ArrayList<Exercice> exerciceList;

    public ExerciceAdapter(Context myContext, ArrayList<Exercice> exerciceList) {
        this.myContext = myContext;
        this.exerciceList = exerciceList;
    }
    @NonNull
    @Override
    public ExerciceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(R.layout.list_exercices, null);
        return new ExerciceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciceViewHolder holder, int position) {
        Exercice exercice = exerciceList.get(position);
        holder.descriptionExerciceTextView.setText(exercice.getDescription());
        holder.nameExerciceTextView.setText(exercice.getName());
        Picasso.get()
                .load(exercice.getUrl())
                .fit().centerCrop()
                .into(holder.exerciceImageView);
    }
    @Override
    public int getItemCount() {
        return exerciceList.size();
    }

     class ExerciceViewHolder extends RecyclerView.ViewHolder {
         private final ImageView exerciceImageView;
         private final TextView nameExerciceTextView;
         private final TextView descriptionExerciceTextView;

         public ExerciceViewHolder(@NonNull View itemView) {
             super(itemView);
             exerciceImageView = itemView.findViewById(R.id.exerciceImageView);
             nameExerciceTextView = itemView.findViewById(R.id.nameExerciceTextView);
             descriptionExerciceTextView = itemView.findViewById(R.id.descriptionExerciceTextView);

    }
    }
}
