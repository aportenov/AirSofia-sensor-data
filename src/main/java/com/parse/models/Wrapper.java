package com.parse.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Wrapper implements Serializable{
    
    @Id
    private Long id;
    private String name;
    private String city;
    
    @JsonProperty(value = "sampling_rate")
    private String samplingRate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    
    private Location location;
    private Sensor sensor;
    
    @JsonProperty(value = "sensordatavalues")
    private List<Measurement> sensorDataValues;
}
