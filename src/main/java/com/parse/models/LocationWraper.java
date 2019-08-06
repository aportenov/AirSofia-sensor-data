package com.parse.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ToString
@Document
public class LocationWraper implements Serializable{
    
    	@Id
    	private Long id;
	
	@JsonProperty(value="display_name")
	private String displayName;
	
	@JsonProperty(value = "address")
	private Address address;

}
