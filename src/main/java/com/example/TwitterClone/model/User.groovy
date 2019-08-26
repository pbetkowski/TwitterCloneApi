package com.example.TwitterClone.model

import com.example.TwitterClone.utils.HashUtils
import com.fasterxml.jackson.annotation.JsonBackReference
import groovy.transform.Canonical

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.validation.constraints.NotNull

@Canonical
@Entity
class User extends BaseEntity{

    @NotNull
    String username

    @NotNull
    String password

    @NotNull
    String email

    @JsonBackReference
    @OneToMany(mappedBy = "followeeId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Follower> followers

    User(String username, String password, String email) {
        this.username = username
        this.password = HashUtils.md5Encryption(password)
        this.email = email
        this.followers = new ArrayList<>()
    }

    User(){}
}
