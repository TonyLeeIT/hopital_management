package com.infoplus.hopital.repository;


import com.infoplus.hopital.model.DiseaseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends PagingAndSortingRepository<DiseaseEntity , String> {
}
