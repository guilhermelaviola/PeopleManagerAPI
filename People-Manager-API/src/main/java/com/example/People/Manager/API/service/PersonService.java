package com.example.People.Manager.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.People.Manager.API.dto.mapper.PersonMapper;
import com.example.People.Manager.API.dto.request.PersonDTO;
import com.example.People.Manager.API.dto.response.MessageResponseDTO;
import com.example.People.Manager.API.entity.Person;
import com.example.People.Manager.API.repository.PersonRepo;

@Service
public class PersonService {
	
	private PersonRepo personRepo;
	
	private PersonMapper personMapper;

	@Autowired
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		
		Person personToSave  = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepo.save(personToSave);
		return MessageResponseDTO.builder().message("Person with ID created!" + savedPerson.getId()).build();
	}
}
