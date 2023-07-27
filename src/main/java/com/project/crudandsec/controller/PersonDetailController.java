package com.project.crudandsec.controller;
import com.project.crudandsec.dto.PersonDetailDTO;
import com.project.crudandsec.service.PersonDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/persondetails")
public class PersonDetailController {
    private PersonDetailService personDetailService;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody PersonDetailDTO personDetailDTO){
        this.personDetailService.add(personDetailDTO);

    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        this.personDetailService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody PersonDetailDTO personDetailDTO){
        this.personDetailService.update(personDetailDTO);

    }

    @GetMapping()
    public List<PersonDetailDTO> findAll(){
        return this.personDetailService.findAll();

    }

    @GetMapping("/{id}")
    public PersonDetailDTO getById(@PathVariable int id){
        return this.personDetailService.getById(id);
    }


}
