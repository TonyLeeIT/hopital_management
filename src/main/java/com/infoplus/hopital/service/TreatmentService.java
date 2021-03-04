package com.infoplus.hopital.service;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.TreatmentEntity;
import org.springframework.data.domain.Page;

public interface TreatmentService {

    Page<TreatmentEntity> getAll(SearchRequest searchRequest);
}
