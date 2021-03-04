package com.infoplus.hopital.repository;

import com.infoplus.hopital.model.DoctorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends PagingAndSortingRepository<DoctorEntity, String> {

}
