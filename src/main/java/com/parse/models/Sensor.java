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
public class Sensor implements Serializable{
    
    @Id
    private long id;
    private Integer pin;
    
    @JsonProperty(value = "sensor_type")
    private SensorType sensorType;

}
