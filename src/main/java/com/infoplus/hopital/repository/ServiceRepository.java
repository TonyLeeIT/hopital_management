package com.infoplus.hopital.repository;

import com.infoplus.hopital.model.ServiceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<ServiceEntity , String> {
}
