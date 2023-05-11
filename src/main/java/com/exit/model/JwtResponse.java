package com.exit.model;

/*
    This will send the response put by the user that is username and password
 */
public class JwtResponse {

    String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
