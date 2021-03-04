package com.infoplus.hopital.service;

import com.infoplus.hopital.model.DoctorEntity;
import com.infoplus.hopital.model.SearchRequest;
import org.springframework.data.domain.Page;

public interface DoctorService {

    Page<DoctorEntity> getAll(SearchRequest searchRequest);
}
