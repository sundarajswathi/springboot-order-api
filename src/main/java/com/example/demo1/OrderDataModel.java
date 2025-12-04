package com.example.demo1;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="formdata")
public class OrderDataModel {
    @Id
    private String id;
    private String name;
    private String address;
  
    private String pno;
private String message;
    private String district;
    private String street;
    private LocalDate date=LocalDate.now();
}
