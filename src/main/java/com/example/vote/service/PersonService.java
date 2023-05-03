package com.example.vote.service;

import com.example.vote.dto.PersonDto;
import com.example.vote.exception.PersonNotFoundException;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();
    void deletePersonById(Integer id) throws PersonNotFoundException;
    PersonDto createPerson(PersonDto personDto) ;
    PersonDto updatePerson(PersonDto personDto) ;
    PersonDto getPersonById(Integer id) throws PersonNotFoundException;
}
