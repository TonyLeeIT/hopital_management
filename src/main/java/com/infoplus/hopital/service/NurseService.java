package com.infoplus.hopital.service;

import com.infoplus.hopital.model.NurseEntity;
import com.infoplus.hopital.model.SearchRequest;
import org.springframework.data.domain.Page;

public interface NurseService {

    Page<NurseEntity> getAll(SearchRequest searchRequest);
}
