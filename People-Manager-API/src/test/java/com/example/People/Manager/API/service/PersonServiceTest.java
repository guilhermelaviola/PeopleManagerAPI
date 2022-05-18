package com.example.People.Manager.API.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.People.Manager.API.dto.request.PersonDTO;
import com.example.People.Manager.API.dto.response.MessageResponseDTO;
import com.example.People.Manager.API.entity.Person;
import com.example.People.Manager.API.repository.PersonRepo;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepo personRepo;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenpersonDTOandThenReturnTheSameMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();
		
		Mockito.when(personRepo.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);	
		
		MessageResponseDTO expectedSuccessMessage = createExpectedMessageResoponse(expectedSavedPerson.getId());
		
		MessageResponseDTO successMessage = personService.createPerson(personDTO);
		
		Assertions.assertEquals(expectedSuccessMessage, successMessage);
	}

	private MessageResponseDTO createExpectedMessageResoponse(Long id) {
		return MessageResponseDTO.builder()
				.message("Created person with ID: " + id)
				.build();
	}

}
