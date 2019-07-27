package com.parser;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class SensorType implements Serializable{

    private Long id;
    private String name;
    private String mamanufacturer;
}
