package com.example.TwitterClone.model

import groovy.transform.Canonical

import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Canonical
@Entity
class Message extends BaseEntity{

    @NotNull
    private Integer authorId

    @NotNull
    private String text

    @NotNull
    private Date publishDate
}

//