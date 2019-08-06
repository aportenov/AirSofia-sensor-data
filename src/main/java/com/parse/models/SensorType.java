package com.parse.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Document
public class SensorType implements Serializable{

    @Id
    private long id;
    private String name;
    private String mamanufacturer;
}
