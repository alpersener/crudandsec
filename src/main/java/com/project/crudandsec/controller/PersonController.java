package com.project.crudandsec.controller;
import com.project.crudandsec.dto.PersonDTO;
import com.project.crudandsec.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody PersonDTO personDTO){
        this.personService.add(personDTO);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        PersonDTO person=personService.getById(id);
        if(person==null)
            throw new RuntimeException("Person Not Found!"+id);
        personService.deleteById(id);

    }


    @PutMapping()
    public void update(@RequestBody PersonDTO personDTO){
        this.personService.update(personDTO);
    }

    @GetMapping()
    public List<PersonDTO> findAll(){
        return this.personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable int id){
        return this.personService.getById(id);
    }



}
