package com.example.vote.model;

import lombok.*;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "persons", schema = "vote") // schema
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // sequence
    private Integer id;
    /**
     * наиме6новаеием
     */
    private String name;
    private String document;
    @Enumerated(EnumType.STRING)
    private VoteType voteType;

}

