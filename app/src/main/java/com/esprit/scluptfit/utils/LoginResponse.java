package com.esprit.scluptfit.utils;

public class LoginResponse {
    private String idUser;

    public LoginResponse(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
