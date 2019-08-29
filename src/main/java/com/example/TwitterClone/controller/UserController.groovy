package com.example.TwitterClone.controller

import com.example.TwitterClone.model.User
import com.example.TwitterClone.security.Token
import com.example.TwitterClone.service.UserService
import com.example.TwitterClone.utils.HashUtils
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private UserService userService

    @GetMapping(value = "/getAllTwitterUsers")
    Flux<User> getAllTwitterUsers() {
        userService.getAllTwitterUsers()
    }

    @GetMapping(value = "/getUserByEmail")
    Mono<User> getUserByEmail(@RequestParam(value = "email") String email) {
        userService.getUserByEmail(email)
    }

    @PostMapping(value = "/registerNewTwitterUser")
    Mono<User> registerNewTwitterUser(@RequestBody User user) {
        userService.registerNewTwitterUser(new User(user.username, user.password, user.email))
    }


    @Deprecated
    @GetMapping(value = "/login")
    Mono<Token> login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {

        userService.getUserByEmail(email)
                .filter({ (it.password == HashUtils.md5Encryption(password)) })
                .map({HashUtils.generateWebToken(it.email)})
    }

}


