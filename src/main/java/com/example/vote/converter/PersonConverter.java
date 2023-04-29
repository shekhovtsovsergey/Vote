package com.example.vote.converter;


import com.example.vote.dto.PersonDto;
import com.example.vote.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonConverter {

    public PersonDto entityToDto(Person person) {
        return new PersonDto(person.getId(), person.getName(),person.getDocument(),person.getVoteType());
    }
}
