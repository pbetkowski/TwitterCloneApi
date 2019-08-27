package com.example.TwitterClone.utils

import com.example.TwitterClone.security.Token

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

class HashUtils {

    static String md5Encryption(String text) {
        byte [] bytesOfMessage = text.getBytes(StandardCharsets.UTF_8)
        MessageDigest algorithm = MessageDigest.getInstance("MD5")
        algorithm.digest(bytesOfMessage).toString()
    }

    static Token generateWebToken(String email) {
        long randomNumber = Math.abs(new Random().nextLong())
        new Token(md5Encryption(email + Long.toString(randomNumber, 16)))
    }
}
