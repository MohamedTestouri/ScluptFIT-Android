package com.esprit.scluptfit.views.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.services.PostService;
import com.esprit.scluptfit.views.activities.CommentActivity;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.core.content.ContextCompat.startActivity;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ForumViewHolder> {
    private Context context;
    private ArrayList<Post> postArrayList = new ArrayList<>();
    private OnPostListener onPostListener;
    PostService postService = new PostService();

    public ForumAdapter(Context context, ArrayList<Post> postArrayList, OnPostListener onPostListener) {
        this.context = context;
        this.postArrayList = postArrayList;
        this.onPostListener = onPostListener;
    }

    public void setOnPostListener(OnPostListener onPostListener) {
        this.onPostListener = onPostListener;
    }

    @NonNull
    @Override
    public ForumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_posts, null);
        return new ForumViewHolder(view, onPostListener);
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
        holder.likesTextView.setText("" + post.getLikes());
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
        private TextView likesTextView;

        OnPostListener onPostListener;
        private Boolean clicked = false;

        public ForumViewHolder(@NonNull View itemView, OnPostListener onPostListener) {
            super(itemView);
            this.onPostListener = onPostListener;
            imageUserImageView = itemView.findViewById(R.id.img_profile);
            datePostTextView = itemView.findViewById(R.id.datePostTextView);
            nameUserTextView = itemView.findViewById(R.id.nameUserTextView);
            textPostTextView = itemView.findViewById(R.id.textPostTextView);
            imagePostImageView = itemView.findViewById(R.id.imagePostImageView);
            likesTextView = itemView.findViewById(R.id.nbr_like);
            likeButton = itemView.findViewById(R.id.likeButton);
            likeButton.setOnClickListener(l -> {
                onPostListener.onLikePost(getAdapterPosition());
                int oldLikes = postArrayList.get(getAdapterPosition()).getLikes();
                if (!clicked) {
                    likeButton.setBackgroundColor(Color.parseColor("#FFE30F39"));
                    postArrayList.get(getAdapterPosition()).setLikes(oldLikes + 1);
                    likesTextView.setText(String.valueOf(Integer.parseInt(likesTextView.getText().toString()) + 1));
                    clicked = true;
                } else {
                    likeButton.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    postArrayList.get(getAdapterPosition()).setLikes(oldLikes - 1);
                    likesTextView.setText(String.valueOf(Integer.parseInt(likesTextView.getText().toString()) - 1));
                    clicked = false;
                }
                postService.updatePostLikes(postArrayList.get(getAdapterPosition()).getIdPost(), new Post(postArrayList.get(getAdapterPosition()).getLikes()));
            });
            commentButton = itemView.findViewById(R.id.commentButton);
            commentButton.setOnClickListener(l -> {
                Intent intent=new Intent(l.getContext(),CommentActivity.class);
                l.getContext().startActivity(intent);
            });
        }
    }

    public interface OnPostListener {
        void onLikePost(int position);
    }
}
