package com.parser;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class Address implements Serializable{
	
	private String road;
	
	private String city;
	
	private String region;
	
	private String country;
	
	@JsonProperty(value= "country_code")
	private String countryCode;

}
