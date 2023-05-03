package com.example.vote.mapper;

import com.example.vote.dto.PersonDto;
import com.example.vote.model.Person;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto toDto(Person person);
}
