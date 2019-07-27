package com.parser;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Wrapper implements Serializable{
    
    private Long id;
    
    private String name;
    
    @JsonIgnore
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
