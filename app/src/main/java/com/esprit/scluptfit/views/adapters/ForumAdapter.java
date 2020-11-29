package com.esprit.scluptfit.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Post;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ForumViewHolder> {
    private Context context;
    private ArrayList<Post> postArrayList = new ArrayList<>();

    public ForumAdapter(Context context, ArrayList<Post> postArrayList) {
        this.context = context;
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public ForumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_posts, null);
        return new ForumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumViewHolder holder, int position) {
        Post post = postArrayList.get(position);
        Picasso.get()
                .load(post.getImage())
                .fit().centerCrop()
                .into(holder.imagePostImageView);
        holder.datePostTextView.setText(post.getIdUser());
        holder.datePostTextView.setText(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(post.getDate()));
        holder.textPostTextView.setText(post.getText());
        holder.nbrlikeTextViwe.setText(""+post.getLikes());
       /* Picasso.get()
                .load(post.getImage())
                .fit().centerCrop()
                .into(holder.imageUserImageView);*/
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public class ForumViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageUserImageView;
        private TextView nameUserTextView;
        private TextView datePostTextView;
        private TextView textPostTextView;
        private ImageView imagePostImageView;
        private RelativeLayout likeButton;
        private RelativeLayout commentButton;
        private TextView nbrlikeTextViwe;



        public ForumViewHolder(@NonNull View itemView) {
            super(itemView);
            imageUserImageView = itemView.findViewById(R.id.img_profile);
            datePostTextView = itemView.findViewById(R.id.datePostTextView);
            nameUserTextView = itemView.findViewById(R.id.nameUserTextView);
            textPostTextView = itemView.findViewById(R.id.textPostTextView);
            imagePostImageView = itemView.findViewById(R.id.imagePostImageView);
            nbrlikeTextViwe = itemView.findViewById(R.id.nbr_like);
            likeButton = itemView.findViewById(R.id.likeButton);
            commentButton = itemView.findViewById(R.id.commentButton);
        }
    }
}
