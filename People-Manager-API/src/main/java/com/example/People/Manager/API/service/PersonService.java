package com.example.People.Manager.API.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.People.Manager.API.dto.mapper.PersonMapper;
import com.example.People.Manager.API.dto.request.PersonDTO;
import com.example.People.Manager.API.dto.response.MessageResponseDTO;
import com.example.People.Manager.API.entity.Person;
import com.example.People.Manager.API.exceptions.PersonNotFoundException;
import com.example.People.Manager.API.repository.PersonRepo;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	private PersonRepo personRepo;

	private PersonMapper personMapper;
	
	@Autowired
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	// Creates a person
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave  = personMapper.toModel(personDTO);

		Person savedPerson = personRepo.save(personToSave);
		return createMessageResponse(savedPerson.getId(), "Created person with id.");
	}

	// Returns a list of people
	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepo.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}

	// Verifies if person exists based on its id and then returns it.
	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}

	// Verifies if person exists and then updates it
	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		verifyIfExists(id);
		
		Person personToUpdate  = personMapper.toModel(personDTO);

		Person savedPerson = personRepo.save(personToUpdate);
		return createMessageResponse(savedPerson.getId(), "Updated person with id.");
	}

	// Verifies if person exists based on its id and then deletes it.
	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		personRepo.deleteById(id);
	}

	// Its a good practice to have this method in the application
	// because it's a single point for maintenance and it helps you
	// avoid duplicated code, which is a bad thing.
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepo.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}
	
	// Creates a message response, another improvement to avoid duplicated code
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder()
				.message(message + id)
				.build();
	}

}
