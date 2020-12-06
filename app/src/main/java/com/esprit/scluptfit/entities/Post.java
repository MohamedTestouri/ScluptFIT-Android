package com.esprit.scluptfit.entities;

import java.util.ArrayList;
import java.util.Date;

public class Post {

    private String idPost;
    private String text;
    private int likes;
    private Date date;
    private String image;
    private String idUser;

    private ArrayList<Comment> CommentArrayList;

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
