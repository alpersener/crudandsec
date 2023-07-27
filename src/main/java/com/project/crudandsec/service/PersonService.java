package com.project.crudandsec.service;
import com.project.crudandsec.dto.PersonDTO;
import java.util.List;
public interface PersonService {

    void add(PersonDTO personDTO);

    void deleteById(int id);

    void update(PersonDTO personDTO);

    List<PersonDTO> findAll();

    PersonDTO getById(int id);






}
