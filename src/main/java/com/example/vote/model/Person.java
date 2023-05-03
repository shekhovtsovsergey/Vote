package com.example.vote.model;

import lombok.*;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "persons", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    /**
     * Имя персоны
     */
    private String name;
    private String document;

    @Column(name = "VOTE_TYPE")
    @Enumerated(EnumType.STRING)
    private VoteType voteType;
    private int is_deleted;
}

