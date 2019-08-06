package com.parse.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Document
public class Location implements Serializable{
    
    @Id
    private long id;
    private Double latitude;
    private Double longitude;
    private Double altitude;
    private String country;
    
    @JsonProperty(value = "exact_location")
    private Integer exactLocation;
    private Integer indoor;
    

}
