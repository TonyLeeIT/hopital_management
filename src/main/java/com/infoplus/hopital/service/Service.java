package com.infoplus.hopital.service;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.ServiceEntity;
import org.springframework.data.domain.Page;

public interface Service {

    Page<ServiceEntity> getAll(SearchRequest searchRequest);
}
