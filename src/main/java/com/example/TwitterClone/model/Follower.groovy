package com.example.TwitterClone.model

import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Entity
@Canonical
class Follower extends BaseEntity{

    @NotNull
    private Integer followeeId
}


//