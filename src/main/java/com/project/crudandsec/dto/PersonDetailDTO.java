package com.project.crudandsec.dto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetailDTO {
    private int id;
    private String gender;
    private int age;

    @JsonBackReference
    private PersonDTO person;

}
