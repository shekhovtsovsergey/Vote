package com.example.vote.service;

import com.example.vote.dao.PersonDao;
import com.example.vote.dto.PersonDto;
import com.example.vote.exception.PersonNotFoundException;
import com.example.vote.mapper.PersonMapper;
import com.example.vote.model.Person;
import com.example.vote.model.VoteType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("Сервис человека")
public class PersonServiceTest {

    private PersonServiceImpl personService;

    @Mock
    private PersonDao personDao;

    @Mock
    private PersonMapper personMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        personService = new PersonServiceImpl(personDao, personMapper);
    }

    @Test
    @DisplayName("должен уметь отдавать список человек")
    public void testGetAllPersons() {
        when(personDao.findAll()).thenReturn(List.of(new Person(1, "John", "123456789", VoteType.YES,0)));

        List<PersonDto> personDtos = new ArrayList<>();
        personDtos.add(new PersonDto(1, "John", "123456789", VoteType.YES));
        when(personMapper.toDto(any())).thenReturn(personDtos.get(0));

        List<PersonDto> result = personService.getAllPersons();
        assertEquals(1, result.size());
        assertEquals(personDtos.get(0).getName(), result.get(0).getName());
        assertEquals(personDtos.get(0).getDocument(), result.get(0).getDocument());
        assertEquals(personDtos.get(0).getVoteType(), result.get(0).getVoteType());
    }


    @Test
    @DisplayName("должен уметь создавать человека")
    public void testCreatePerson() {
        Person person = new Person(1, "John", "123456789", VoteType.YES,0);
        when(personDao.save(any(Person.class))).thenReturn(person);

        PersonDto personDto = new PersonDto(null, "John", "123456789", VoteType.YES);
        when(personMapper.toDto(any())).thenReturn(new PersonDto(1, "John", "123456789", VoteType.YES));

        PersonDto result = personService.createPerson(personDto);
        assertEquals("John", result.getName());
        assertEquals("123456789", result.getDocument());
        assertEquals(VoteType.YES, result.getVoteType());
    }

    @Test
    @DisplayName("должен уметь обновлять человека")
    public void testUpdatePerson() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "John", "123456789", VoteType.YES,0));
        when(personDao.findAll()).thenReturn(persons);

        Person person = new Person(1, "Johnny", "987654321", VoteType.NO,0);
        when(personDao.save(any(Person.class))).thenReturn(person);

        PersonDto personDto = new PersonDto(1, "Johnny", "987654321", VoteType.NO);
        when(personMapper.toDto(any())).thenReturn(personDto);

        PersonDto result = personService.updatePerson(personDto);
        assertEquals("Johnny", result.getName());
        assertEquals("987654321", result.getDocument());
        assertEquals(VoteType.NO, result.getVoteType());
    }

    @Test
    @DisplayName("должен уметь отдавать человека по id")
    public void testGetPersonById() throws PersonNotFoundException {
        PersonDao personDao = mock(PersonDao.class);

        when(personDao.findById(1)).thenReturn(Optional.of(new Person(1, "John", "123456789", VoteType.YES,0)));
        when(personMapper.toDto(any(Person.class))).thenReturn(new PersonDto(1, "John", "123456789", VoteType.YES));

        PersonService personService = new PersonServiceImpl(personDao, personMapper);
        PersonDto personDto = personService.getPersonById(1);

        assertNotNull(personDto);
        assertEquals(personDto.getName(), "John");
        assertEquals(personDto.getDocument(), "123456789");
        assertEquals(personDto.getVoteType(), VoteType.YES);
    }



    @Test
    @DisplayName("должен уметь возвращать ошибку если идентификатор человека не найден")
    public void testGetPersonByIdNotFound() {
        when(personDao.findById(1)).thenReturn(Optional.empty());
        try {//assertThrows
            personService.getPersonById(1);
        } catch (PersonNotFoundException e) {
            assertEquals("Person id 1 not found", e.getMessage());
        }
        //
        verify(personDao, times(1)).findById(1);
        verify(personMapper, never()).toDto(any());
    }


}