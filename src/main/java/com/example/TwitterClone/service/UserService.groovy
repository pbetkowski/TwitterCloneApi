package com.example.TwitterClone.service

import com.example.TwitterClone.model.User
import com.example.TwitterClone.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService {

    @Autowired
    private UserRepository userRepository

    Flux<User> getAllTwitterUsers() {
        Flux.fromIterable(userRepository.findAll())
    }

    Mono<User> getUserByEmail(String email) {
        Mono.just(userRepository.getUserByEmail(email))
    }

    Mono<User> registerNewTwitterUser(User user) {
        Mono.just(userRepository.save(user))
    }
}

