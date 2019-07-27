package com.parser;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Measurement implements Serializable{

    
    private Long id;
    private String value;
    
    @JsonProperty(value = "value_type")
    private String valueType;
}
