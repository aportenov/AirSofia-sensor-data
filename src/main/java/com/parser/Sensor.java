package com.parser;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Sensor implements Serializable{
    
    private Long id;
    private Integer pin;
    
    @JsonProperty(value = "sensor_type")
    private SensorType sensorType;

}
