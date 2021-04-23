package com.infoplus.hopital.repository.specifications;

import com.infoplus.hopital.model.DoctorEntity;
import com.infoplus.hopital.model.DoctorEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DoctorSpecification {

    public static Specification<DoctorEntity> containName(String nameDoctor) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get(DoctorEntity_.NAME_DOCTOR), "%" + nameDoctor + "%"));
    }

    public static Specification<DoctorEntity> hasId(String idDoctor) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(DoctorEntity_.ID_DOCTOR), idDoctor));
    }


    public static Specification<DoctorEntity> hasAddress(String address) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(DoctorEntity_.ADDRESS), address));
    }
}
