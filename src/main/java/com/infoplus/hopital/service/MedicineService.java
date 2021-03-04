package com.infoplus.hopital.service;

import com.infoplus.hopital.model.MedicineEntity;
import com.infoplus.hopital.model.SearchRequest;
import org.springframework.data.domain.Page;

public interface MedicineService {

    Page<MedicineEntity> getAll(SearchRequest searchRequest);
}
