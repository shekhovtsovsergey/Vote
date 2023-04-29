package com.example.vote.service;

import com.example.vote.converter.PersonConverter;
import com.example.vote.dao.PersonDao;
import com.example.vote.dto.PersonDto;
import com.example.vote.exaption.PersonNotFoundException;
import com.example.vote.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {


    private final PersonDao personDao;
    private final PersonConverter personConverter;

    @Override
    public List<PersonDto> getAllPersons() {
        return personDao.findAll().stream().map(personConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<PersonDto> deletePersonById(Integer id) {
        return personDao.findAll().stream().map(personConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PersonDto createPerson(PersonDto personDto) {
        Person person = new Person(null, personDto.getName(), personDto.getDocument(), personDto.getVoteType());
        return personConverter.entityToDto(personDao.save(person));
    }

    @Override
    @Transactional
    public PersonDto updatePerson(PersonDto personDto)  {
        Person person = new Person(personDto.getId(), personDto.getName(), personDto.getDocument(), personDto.getVoteType());
        return personConverter.entityToDto(personDao.save(person));
    }


    @Override
    public PersonDto getPersonById(Integer id) throws PersonNotFoundException {
        return personConverter.entityToDto(personDao.findById(id).orElseThrow(() -> new PersonNotFoundException(id)));
    }
}