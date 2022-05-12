package com.example.People.Manager.API.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.People.Manager.API.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;
	
	@NotEmpty
	@Size(min = 7, max = 13)
	private String phoneNumber;
}
