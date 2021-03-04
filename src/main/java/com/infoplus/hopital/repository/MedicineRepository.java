package com.infoplus.hopital.repository;

import com.infoplus.hopital.model.MedicineEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends PagingAndSortingRepository<MedicineEntity , String> {
}
