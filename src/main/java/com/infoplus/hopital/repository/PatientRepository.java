package com.infoplus.hopital.repository;


import com.infoplus.hopital.model.PatientEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PatientRepository extends PagingAndSortingRepository<PatientEntity, String> {

}
