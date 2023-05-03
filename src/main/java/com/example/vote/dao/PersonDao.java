package com.example.vote.dao;

import com.example.vote.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * DAO repository для операций по
 * - персонами
 * - проекции по статистистике
 *
 */
public interface PersonDao extends JpaRepository<Person, Integer> {
}
