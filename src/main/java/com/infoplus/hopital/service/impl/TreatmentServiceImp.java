package com.infoplus.hopital.service.impl;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.TreatmentEntity;
import com.infoplus.hopital.repository.ExaminationRepository;
import com.infoplus.hopital.repository.TreatmentRepository;
import com.infoplus.hopital.repository.TreatmentRepositoryCustom;
import com.infoplus.hopital.service.TreatmentService;
import com.infoplus.hopital.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TreatmentServiceImp implements TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private TreatmentRepositoryCustom treatmentRepositoryCustom;

    @Override
    @Transactional(readOnly = true)
    public Page<TreatmentEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("idTreatment").ascending());
        return treatmentRepository.findAll(pageable);
    }

    @Override
    @Modifying
    @Transactional
    public void callProcedureTreatment(String idNurseValue, boolean statusValue)  {
        String res = treatmentRepositoryCustom.pushTreatmentDownDatabase(idNurseValue ,statusValue );
        System.out.println(res);
    }
}
