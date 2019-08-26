package com.example.TwitterClone.controller

import com.example.TwitterClone.model.User
import com.example.TwitterClone.service.UserService
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

    //todo login with comparing hashed passwords

}


