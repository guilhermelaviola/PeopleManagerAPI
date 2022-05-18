package com.example.People.Manager.API.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Personalized exception for person not found
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {

	public PersonNotFoundException(Long id) {
		super("Person with id " + id + " not found.");
	}
}
