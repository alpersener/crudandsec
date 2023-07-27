package com.project.crudandsec.repository;

import com.project.crudandsec.entity.PersonDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDetailRepository extends JpaRepository<PersonDetail,Integer> {
}
