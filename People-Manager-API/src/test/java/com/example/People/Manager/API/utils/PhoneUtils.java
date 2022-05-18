package com.example.People.Manager.API.utils;

import com.example.People.Manager.API.dto.request.PhoneDTO;
import com.example.People.Manager.API.entity.Phone;
import com.example.People.Manager.API.enums.PhoneType;

public class PhoneUtils {

	private static final String PHONE_NUMBER = "4456734277";
	private static final PhoneType PHONE_TYPE = PhoneType.HOME;
	private static final long PHONE_ID = 1L;
	
	public static PhoneDTO createFakeDTO() {
		return PhoneDTO.builder()
				.phoneNumber(PHONE_NUMBER)
				.phoneType(PHONE_TYPE)
				.build();
	}
	
	public static Phone createFakeEntity() {
		return Phone.builder()
				.id(PHONE_ID)
				.phoneNumber(PHONE_NUMBER)
				.phoneType(PHONE_TYPE)
				.build();
	}
}
