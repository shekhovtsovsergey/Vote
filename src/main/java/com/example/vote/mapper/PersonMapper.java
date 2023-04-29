package com.example.vote.mapper;

import com.example.vote.dto.PersonDto;
import com.example.vote.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);
    PersonDto toDto(Person person);
}
