package com.parser;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Location implements Serializable{
    
    private Long id;
    private Double latitude;
    private Double longitude;
    private Double altitude;
    private String country;
    
    @JsonProperty(value = "exact_location")
    private Integer exactLocation;
    private Integer indoor;
    

}
