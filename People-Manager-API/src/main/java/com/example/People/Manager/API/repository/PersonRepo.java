package com.example.People.Manager.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.People.Manager.API.entity.Person;

@Repository
@Component
@EnableJpaRepositories
public interface PersonRepo extends JpaRepository<Person, Long> {

}
