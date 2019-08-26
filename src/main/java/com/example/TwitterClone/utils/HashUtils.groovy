package com.example.TwitterClone.utils

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

class HashUtils {

    static byte [] md5Encryption(String text) {
        byte [] bytesOfMessage = text.getBytes(StandardCharsets.UTF_8)
        MessageDigest algorithm = MessageDigest.getInstance("MD5")
        algorithm.digest(bytesOfMessage)
    }
}
