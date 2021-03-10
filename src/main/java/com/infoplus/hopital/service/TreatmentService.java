package com.infoplus.hopital.service;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.TreatmentEntity;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.Date;

public interface TreatmentService {

    Page<TreatmentEntity> getAll(SearchRequest searchRequest);

    void callProcedureTreatment(String idNurseValue, boolean statusValue) throws ParseException;
}
