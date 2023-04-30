package com.example.vote.controller;


import com.example.vote.dto.PersonDto;
import com.example.vote.exception.PersonNotFoundException;
import com.example.vote.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/persons")
public class PersonRestController {

    private final PersonService service;

    @GetMapping
    public List<PersonDto> getPersonList() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable Integer id) throws PersonNotFoundException {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/api/v1/person/{id}")
    public void deletePersonById(@PathVariable(name = "id") Integer id) {
        personService.deletePersonById(id);
    }

    @PutMapping("/api/v1/person/{id}")
    public PersonDto updatePerson(@Validated @RequestBody PersonDto PersonDto)  {
        return personService.updatePerson(PersonDto);
    }

    @PostMapping("/api/v1/person")
    public PersonDto createPerson(@Validated @RequestBody PersonDto PersonDto) {
        return personService.createPerson(PersonDto);
    }

    @ExceptionHandler({
            PersonNotFoundException.class,

    })
    private ResponseEntity<String> handleNotFound(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
