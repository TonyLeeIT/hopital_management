package com.infoplus.hopital.repository.custom;

import com.infoplus.hopital.model.DoctorEntity;
import com.infoplus.hopital.model.DoctorEntity_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DoctorCustomRepositoryImp implements DoctorCustomRepository  {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<DoctorEntity> findDoctorsByIdAndName(String idDoctor, String nameDoctor) {

        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery(DoctorEntity.class);

        Root<DoctorEntity> doctor=cq.from(DoctorEntity.class);

        Predicate idPredicate=cb.equal(doctor.get(DoctorEntity_.ID_DOCTOR),idDoctor);
        Predicate namePredicate=cb.equal(doctor.get(DoctorEntity_.NAME_DOCTOR),nameDoctor);

        cq.where(idPredicate,namePredicate);

        TypedQuery<DoctorEntity> query=entityManager.createQuery(cq);

        return query.getResultList();
    }
}
