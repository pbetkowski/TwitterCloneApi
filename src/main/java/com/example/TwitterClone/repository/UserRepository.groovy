package com.example.TwitterClone.repository

import com.example.TwitterClone.model.Follower
import com.example.TwitterClone.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByEmail(String email)

}
