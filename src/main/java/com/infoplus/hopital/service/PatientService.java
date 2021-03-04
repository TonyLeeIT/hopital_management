package com.infoplus.hopital.service;

import com.infoplus.hopital.model.PatientEntity;
import com.infoplus.hopital.model.SearchRequest;
import org.springframework.data.domain.Page;

public interface PatientService {

    Page<PatientEntity> getAll(SearchRequest searchRequest);
}
