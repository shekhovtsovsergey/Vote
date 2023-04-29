package com.example.vote.service;

import com.example.vote.dto.PersonDto;
import com.example.vote.exaption.PersonNotFoundException;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();
    List<PersonDto> deletePersonById(Integer id);
    PersonDto createPerson(PersonDto personDto) ;
    PersonDto updatePerson(PersonDto personDto) ;
    PersonDto getPersonById(Integer id) throws PersonNotFoundException;
}
