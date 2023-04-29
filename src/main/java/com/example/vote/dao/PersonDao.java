package com.example.vote.dao;

import com.example.vote.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonDao extends JpaRepository<Person, Integer> {
}

