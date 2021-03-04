package com.infoplus.hopital.service;

import com.infoplus.hopital.model.ExaminationEntity;
import com.infoplus.hopital.model.SearchRequest;
import org.springframework.data.domain.Page;

public interface ExaminationService {

    Page<ExaminationEntity> getAll(SearchRequest searchRequest);
}
