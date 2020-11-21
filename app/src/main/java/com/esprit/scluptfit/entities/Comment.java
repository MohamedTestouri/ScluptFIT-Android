package com.esprit.scluptfit.entities;

import java.util.Date;

public class Comment {

    private String idComment;
    private String text;
    private Date date;
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
