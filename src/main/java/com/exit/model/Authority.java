package com.exit.model;

import org.springframework.security.core.GrantedAuthority;

/*
    This class is used to check the authority that the user is admin user or normal user
 */
public class Authority implements GrantedAuthority {

    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
