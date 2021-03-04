package com.infoplus.hopital.service.impl;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.TreatmentEntity;
import com.infoplus.hopital.repository.TreatmentRepository;
import com.infoplus.hopital.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TreatmentServiceImp implements TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<TreatmentEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("idTreatment").ascending());
        return treatmentRepository.findAll(pageable);
    }
}
