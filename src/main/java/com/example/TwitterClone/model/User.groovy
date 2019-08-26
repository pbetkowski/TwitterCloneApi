package com.example.TwitterClone.model

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
    private String username

    @NotNull
    private String password

    @NotNull
    private String email

    @JsonBackReference
    @OneToMany(mappedBy = "followeeId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Follower> followers
}


//