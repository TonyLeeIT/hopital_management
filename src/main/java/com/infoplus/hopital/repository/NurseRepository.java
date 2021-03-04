package com.infoplus.hopital.repository;


import com.infoplus.hopital.model.NurseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends PagingAndSortingRepository<NurseEntity, String> {
}
