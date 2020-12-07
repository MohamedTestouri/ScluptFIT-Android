package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.services.PostService;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.adapters.CommentAdapter;
import com.esprit.scluptfit.views.adapters.ForumAdapter;
import com.esprit.scluptfit.views.fragments.ForumFragment;

import org.w3c.dom.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity {

    private RecyclerView commentRecyclerView;
    private CommentAdapter commentAdapter;
    private ArrayList<Post.Comment> commentArrayList = new ArrayList<>();
    private PostService postService = new PostService();
    private TextView commentTextView;
    private Button btnAddComment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        //      commentRecyclerView = findViewById(R.id.commentRecyclerView);
        //    commentRecyclerView.setHasFixedSize(false); // no fix size
        //  commentRecyclerView.setLayoutManager(new LinearLayoutManager(CommentActivity.this));

        //commentArrayList.add(new Post.Comment("first status"));
        //commentArrayList.add(new Post.Comment("second status"));

        // postService.getPostsById("5fccc79c1b1ffb0004db3d7e");


        // commentAdapter = new CommentAdapter(CommentActivity.this, commentArrayList);
        //   commentRecyclerView.setAdapter(commentAdapter);


        RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class)
                .getPostsById("5fccc79c1b1ffb0004db3d7e")
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                           // System.out.println(response.body().getIdPost() + "");
                            commentRecyclerView = findViewById(R.id.commentRecyclerView);
                            commentAdapter = new CommentAdapter(CommentActivity.this, response.body().getCommentArrayList());
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CommentActivity.this);
                            commentRecyclerView.setLayoutManager(layoutManager);
                            commentRecyclerView.setAdapter(commentAdapter);

                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        System.out.println("FAILED!");
                    }
                });
        commentTextView = findViewById(R.id.textViewComment);
        btnAddComment = findViewById(R.id.btAddComment);
        btnAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postService.addComment(commentTextView.getText().toString(),"5fcaa6fe55106324acdfdfce","5fccc79c1b1ffb0004db3d7e");
                Toast.makeText(CommentActivity.this,"add ..",Toast.LENGTH_SHORT).show();


            }
        });

    }





}