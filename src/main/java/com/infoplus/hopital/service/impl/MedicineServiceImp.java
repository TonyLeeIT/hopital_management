package com.infoplus.hopital.service.impl;

import com.infoplus.hopital.model.MedicineEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.repository.MedicineRepository;
import com.infoplus.hopital.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MedicineServiceImp implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<MedicineEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("name").ascending());
        return medicineRepository.findAll(pageable);
    }
}
