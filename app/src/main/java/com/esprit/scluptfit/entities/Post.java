package com.esprit.scluptfit.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    @SerializedName("_id")
    private String idPost;
    @SerializedName("text")
    private String text;
    @SerializedName("likes")
    private int likes;
    @SerializedName("date")
    private Date date;
    @SerializedName("image")
    private String image;
    @SerializedName("idUser")
    private String idUser;
    @SerializedName("comments")
    private ArrayList<Comment> CommentArrayList;



    public static class Comment {
        @SerializedName("_id")
        private String idComment;
        @SerializedName("text")
        private String text;
        @SerializedName("date")
        private Date date;
        @SerializedName("idUser")
        private String idUser;


        public Comment(String idComment, String text, Date date, String idUser) {
            this.idComment = idComment;
            this.text = text;
            this.date = date;
            this.idUser = idUser;

        }

        public Comment(String text, String idUser) {
            this.text = text;
            this.idUser = idUser;
        }

        public String getIdComment() {
            return idComment;
        }

        public void setIdComment(String idComment) {
            this.idComment = idComment;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getIdUser() {
            return idUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }
    }

    public Post(String idPost, String text, int likes, Date date, String image, String idUser, ArrayList<Comment> commentArrayList) {
        this.idPost = idPost;
        this.text = text;
        this.likes = likes;
        this.date = date;
        this.image = image;
        this.idUser = idUser;
        CommentArrayList = commentArrayList;
    }

    public Post(ArrayList<Comment> commentArrayList) {
        CommentArrayList = commentArrayList;
    }

    public Post(String text, int likes, String image, String idUser) {
        this.text = text;
        this.likes = likes;
        this.image = image;
        this.idUser = idUser;
    }
    public Post(String text, String idUser) {
        this.text = text;
        this.idUser = idUser;
    }

    public Post(String text, int likes) {
        this.text = text;
        this.likes = likes;
    }
    public Post(String text) {
        this.text = text;

    }
    public Post( int likes) {
        this.likes = likes;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public ArrayList<Comment> getCommentArrayList() {
        return CommentArrayList;
    }

    public void setCommentArrayList(ArrayList<Comment> commentArrayList) {
        CommentArrayList = commentArrayList;
    }
}
