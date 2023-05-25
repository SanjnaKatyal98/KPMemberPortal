package com.example.demo.models;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	//yeh bs ek basic string hai ki jo user hai ooska role kya admin hai ya normal
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}