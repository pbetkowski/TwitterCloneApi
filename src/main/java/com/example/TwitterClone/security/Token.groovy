package com.example.TwitterClone.security

import groovy.transform.Canonical

@Canonical
class Token {

    String token

    Token(String token){
        this.token = token
    }
}
