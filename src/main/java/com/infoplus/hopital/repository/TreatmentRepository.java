package com.infoplus.hopital.repository;


import com.infoplus.hopital.model.TreatmentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends PagingAndSortingRepository<TreatmentEntity , Integer> {

}
