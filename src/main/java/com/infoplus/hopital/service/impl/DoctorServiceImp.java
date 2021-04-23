package com.infoplus.hopital.service.impl;

import com.infoplus.hopital.model.DoctorEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.repository.DoctorRepository;
import com.infoplus.hopital.repository.custom.DoctorCustomRepository;
import com.infoplus.hopital.repository.specifications.DoctorSpecification;
import com.infoplus.hopital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DoctorServiceImp implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorCustomRepository doctorCustomRepository;

    @Override
    public Page<DoctorEntity> getAll(SearchRequest searchRequest) {

        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("nameDoctor").ascending());
        return doctorRepository.findAll(pageable);
    }


//    Use jpa specification
    @Override
    @Transactional(readOnly = true)
    public Page<DoctorEntity> getByIdAndName(String idDoctor , String nameDoctor,SearchRequest searchRequest ) {
        Pageable pageable = PageRequest.of(searchRequest.getPage() , searchRequest.getSize() , Sort.by("nameDoctor").ascending());
        Specification<DoctorEntity> specifications = Specification.where(DoctorSpecification.hasId(idDoctor).and(
                DoctorSpecification.containName(nameDoctor)
        ));
        return doctorRepository.findAll(specifications,pageable);
    }

//    Use Criteria Repository
//    @Override
//    @Transactional(readOnly = true)
//    public List<DoctorEntity> getByIdAndName(String idDoctor , String nameDoctor) {
//        Specification<DoctorEntity> specifications = Specification.where(DoctorSpecification.hasId(idDoctor).and(
//                DoctorSpecification.containName(nameDoctor)
//        ));
//        return doctorCustomRepository.findDoctorsByIdAndName(idDoctor ,nameDoctor);
//    }
}
