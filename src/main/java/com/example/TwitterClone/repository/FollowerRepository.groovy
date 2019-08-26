package com.example.TwitterClone.repository

import com.example.TwitterClone.model.Follower
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FollowerRepository {

    @Query(value = "select * from Follower as f INNER JOIN User u ON f.followeeId = u.Id where u.email = :email", nativeQuery = true)
    List<Follower> getFollowersByUserEmail(@Param("email") String email)
}

//