package com.example.TwitterClone.security

import com.example.TwitterClone.model.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Login {

    @PostMapping(value = "/login")
    String login(@RequestBody User user) {
        long currentTime = System.currentTimeMillis()
        Jwts.builder()
                .setSubject(user.email)
                .claim("roles", "user")
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 36000))
                .signWith(SignatureAlgorithm.HS512, user.getPassword())
                .compact()
    }
}
