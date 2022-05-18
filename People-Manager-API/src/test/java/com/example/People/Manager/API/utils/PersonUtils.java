package com.example.People.Manager.API.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.example.People.Manager.API.dto.request.PersonDTO;
import com.example.People.Manager.API.entity.Person;

public class PersonUtils {

	private static final String FIRST_NAME = "Marcus";
	private static final String LAST_NAME = "Darby";
	private static final String SOCIAL_SECURITY_NUMBER = "67566379874";
	private static final long PERSON_ID = 1l;
	private static final LocalDate BIRTH_DATE = LocalDate.of(1995, 02, 11);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.socialSecurityNumber(SOCIAL_SECURITY_NUMBER)
				.birthDate("11-02-1995")
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
				.build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder()
				.id(PERSON_ID)
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.socialSecurityNumber(SOCIAL_SECURITY_NUMBER)
				.birthDate(BIRTH_DATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}
}
