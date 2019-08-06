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
public class Measurement implements Serializable{

    
    @Id
    private long id;
    private String value;
    
    @JsonProperty(value = "value_type")
    private String valueType;
}
