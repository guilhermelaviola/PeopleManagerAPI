package com.example.People.Manager.API.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.People.Manager.API.dto.request.PersonDTO;
import com.example.People.Manager.API.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO personDTO);
	
	PersonDTO toDTO(Person person);
}
