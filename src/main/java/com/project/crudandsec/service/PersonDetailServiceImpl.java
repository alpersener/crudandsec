package com.project.crudandsec.service;
import com.project.crudandsec.dto.PersonDetailDTO;
import com.project.crudandsec.entity.PersonDetail;
import com.project.crudandsec.mapper.ModelMapperService;
import com.project.crudandsec.repository.PersonDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class PersonDetailServiceImpl implements PersonDetailService{
    private final PersonDetailRepository personDetailRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void add(PersonDetailDTO personDetailDTO) {
        PersonDetail personDetail=this.modelMapperService.getModelMapper().map(personDetailDTO,PersonDetail.class);
        this.personDetailRepository.saveAndFlush(personDetail);
    }

    @Override
    public void deleteById(int id) {
        this.personDetailRepository.deleteById(id);

    }

    @Override
    public void update(PersonDetailDTO personDetailDTO) {
        PersonDetail personDetail=this.modelMapperService.getModelMapper()
                .map(personDetailDTO,PersonDetail.class);
        this.personDetailRepository.saveAndFlush(personDetail);

    }

    @Override
    public List<PersonDetailDTO> findAll() {
       List<PersonDetail> personDetailList=personDetailRepository.findAll();
       List<PersonDetailDTO>personDetailDTOList=personDetailList.stream()
               .map(personDetail -> this.modelMapperService.getModelMapper()
                       .map(personDetail,PersonDetailDTO.class))
               .collect(Collectors.toList());
       return personDetailDTOList;

    }

    @Override
    public PersonDetailDTO getById(int id) {
        PersonDetail personDetail=personDetailRepository.findById(id).orElseThrow();
        PersonDetailDTO personDetailDTO=this.modelMapperService.getModelMapper()
                .map(personDetail,PersonDetailDTO.class);
        return personDetailDTO;
    }
}
