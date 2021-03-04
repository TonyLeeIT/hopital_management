package com.infoplus.hopital.service.impl;

import com.infoplus.hopital.model.NurseEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.repository.NurseRepository;
import com.infoplus.hopital.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NurseServiceImp implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Override
    public Page<NurseEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("nameNurse").ascending());
        return  nurseRepository.findAll(pageable);
    }
}
