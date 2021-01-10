package com.esprit.scluptfit.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.User;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RunningAdapter extends RecyclerView.Adapter<RunningAdapter.RunningViewHolder> {
 private Context context;
 private ArrayList<User.Run> runArrayList = new ArrayList<>();

    public RunningAdapter(Context context, ArrayList<User.Run> runArrayList) {
        this.context = context;
        this.runArrayList = runArrayList;
    }

    @NonNull
    @Override
    public RunningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.list_runs, null);
        return new RunningViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RunningViewHolder holder, int position) {
        System.out.println("not reversed" + runArrayList.toString());
       Collections.reverse(runArrayList);
        System.out.println(" reversed" + runArrayList.toString());
        User.Run run = runArrayList .get(position);
        holder.dateTextView.setText(run.getDate().toString());
        holder.durationTextView.setText(run.getDuration().toString()+" min");
        holder.distanceTextView.setText(run.getDistance().toString()+" KM");
        holder.caloriesTextView.setText(run.getCalories().toString());
    }

    @Override
    public int getItemCount() {
        return runArrayList.size();
    }

    public class RunningViewHolder extends RecyclerView.ViewHolder {
        private TextView dateTextView;
        private TextView durationTextView;
        private TextView distanceTextView;
        private TextView caloriesTextView;
        public RunningViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateRunTextView);
            durationTextView = itemView.findViewById(R.id.durationRunTextView);
            distanceTextView = itemView.findViewById(R.id.distanceRunTextView);
            caloriesTextView = itemView.findViewById(R.id.caloriesRunTextView);

        }

    }
}
