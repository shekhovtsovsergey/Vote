package com.example.vote.model;

import lombok.*;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String document;
    @Enumerated(EnumType.STRING)
    private VoteType voteType;

}

