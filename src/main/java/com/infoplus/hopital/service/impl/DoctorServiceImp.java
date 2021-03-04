package com.infoplus.hopital.service.impl;

import com.infoplus.hopital.model.DoctorEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.repository.DoctorRepository;
import com.infoplus.hopital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImp implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Page<DoctorEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("nameDoctor").ascending());
        return doctorRepository.findAll(pageable);
    }
}
