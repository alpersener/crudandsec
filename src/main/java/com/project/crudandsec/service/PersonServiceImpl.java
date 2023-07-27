package com.project.crudandsec.service;
import com.project.crudandsec.dto.PersonDTO;
import com.project.crudandsec.entity.Person;
import com.project.crudandsec.mapper.ModelMapperService;
import com.project.crudandsec.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(PersonDTO personDTO) {
        Person person=modelMapperService.getModelMapper().map(personDTO,Person.class);
       personRepository.saveAndFlush(person);

    }

    @Override
    public void deleteById(int id) {
        this.personRepository.deleteById(id);

    }

    @Override
    public void update(PersonDTO personDTO) {
        Person person=this.modelMapperService.getModelMapper().map(personDTO,Person.class);
        this.personRepository.saveAndFlush(person);
    }


    @Override
    public List<PersonDTO> findAll() {
        List<Person> personList=personRepository.findAll();
        List<PersonDTO> personDTOList=personList.stream()
                .map(person -> this.modelMapperService.getModelMapper()
                        .map(person, PersonDTO.class))
                .collect(Collectors.toList());
        return personDTOList;
    }

    @Override
    public PersonDTO getById(int id) {
        Person person=this.personRepository.findById(id).orElseThrow();
        PersonDTO personDTO=this.modelMapperService.getModelMapper()
                .map(person,PersonDTO.class);
       return personDTO;
    }
}
