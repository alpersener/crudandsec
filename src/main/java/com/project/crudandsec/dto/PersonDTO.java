package com.project.crudandsec.dto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    @JsonManagedReference
    private PersonDetailDTO personDetail;


}
