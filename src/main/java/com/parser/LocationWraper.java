package com.parser;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ToString
public class LocationWraper implements Serializable{
	
	@JsonProperty(value="display_name")
	private String displayName;
	
	@JsonProperty(value = "address")
	private Address address;

}
