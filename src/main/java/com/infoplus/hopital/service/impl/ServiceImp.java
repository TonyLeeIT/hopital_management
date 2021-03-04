package com.infoplus.hopital.service.impl;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.ServiceEntity;
import com.infoplus.hopital.repository.ServiceRepository;
import com.infoplus.hopital.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@Transactional
public class ServiceImp implements Service {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ServiceEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("nameService").ascending());
        return serviceRepository.findAll(pageable);
    }
}
