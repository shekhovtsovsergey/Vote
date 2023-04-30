package com.example.vote.converter;


import com.example.vote.dto.PersonDto;
import com.example.vote.model.Person;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * always use groups
 *
 *
 * 1. елочка
 * 2. по использованию
 */
@Getter
@ToString
@RequiredArgsConstructor
@Component
@ConfigurationProperties
public class PersonConverter {

    public PersonDto entityToDto(Person person) {
        return new PersonDto(person.getId(), person.getName(),person.getDocument(),person.getVoteType());
    }
}

@Getter
@Setter
@RequiredArgsConstructor
class F {
    private String s;
}