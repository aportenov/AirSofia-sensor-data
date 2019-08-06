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
public class Address implements Serializable {

    @Id
    private long id;

    private String road;

    private String city;

    private String region;

    private String country;

    @JsonProperty(value = "country_code")
    private String countryCode;

}
