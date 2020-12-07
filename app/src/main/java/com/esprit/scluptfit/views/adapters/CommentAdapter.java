package com.esprit.scluptfit.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.entities.User;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder>{
    private Context context;
    private ArrayList<Post.Comment> commentArrayList = new ArrayList<>();

    public CommentAdapter(Context context, ArrayList<Post.Comment> commentArrayList) {
        this.context = context;
        this.commentArrayList = commentArrayList;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comments, parent, false);
        return new CommentViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
Post.Comment comment = commentArrayList.get(position);

            holder.textCommentTextView.setText(comment.getText());
            holder.dateCommentTextView.setText(new SimpleDateFormat("hh:mm:ss").format(comment.getDate()));
      /*
    postComment.get(position).getText();

        holder.dateCommentTextView.setText("15:20");
        holder.nameUserTextView.setText("wassim sefi");
        holder.textCommentTextView.setText();*/

    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageUserImageView;
        private TextView nameUserTextView;
        private TextView textCommentTextView;
        private TextView dateCommentTextView;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            imageUserImageView = itemView.findViewById(R.id.imageUserComment);
            nameUserTextView = itemView.findViewById(R.id.full_nameComment);
            textCommentTextView = itemView.findViewById(R.id.textComment);
            dateCommentTextView = itemView.findViewById(R.id.dateComment);


        }
    }
}
