package com.infoplus.hopital.service.impl;

import com.infoplus.hopital.model.ExaminationEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.repository.ExaminationRepository;
import com.infoplus.hopital.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExaminationServiceImp implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;


    @Override
    @Transactional(readOnly = true)
    public Page<ExaminationEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("idExamination").ascending());
        return examinationRepository.findAll(pageable);
    }
}
