package com.project.crudandsec.service;
import com.project.crudandsec.dto.PersonDetailDTO;
import java.util.List;
public interface PersonDetailService {
    void add(PersonDetailDTO personDetailDTO);

    void deleteById(int id);

    void update(PersonDetailDTO personDetailDTO);

    List<PersonDetailDTO> findAll();

    PersonDetailDTO getById(int id);
}
