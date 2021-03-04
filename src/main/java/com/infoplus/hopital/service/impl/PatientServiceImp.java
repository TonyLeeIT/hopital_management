package com.infoplus.hopital.service.impl;


import com.infoplus.hopital.model.PatientEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.repository.PatientRepository;
import com.infoplus.hopital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Page<PatientEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("namePatient").ascending());
        return patientRepository.findAll(pageable) ;
    }
}
