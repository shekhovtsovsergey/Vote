package com.example.vote.dto;


import com.example.vote.model.VoteType;
import lombok.*;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String document;
    @NotNull
    @Enumerated(EnumType.STRING)
    private VoteType voteType;

}