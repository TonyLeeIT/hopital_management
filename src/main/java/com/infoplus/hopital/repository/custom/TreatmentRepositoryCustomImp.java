package com.infoplus.hopital.repository.custom;

import org.hibernate.procedure.ProcedureOutputs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class TreatmentRepositoryCustomImp implements TreatmentRepositoryCustom {

    public static Logger logger = LoggerFactory.getLogger(TreatmentRepositoryCustomImp.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String pushTreatmentDownDatabase(String idNurseValue, boolean statusValue) {

        String res = "";
        StoredProcedureQuery spQuery = entityManager.createStoredProcedureQuery("PR_TREATMENT")
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, boolean.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)
                .setParameter(1, idNurseValue)
                .setParameter(2, statusValue);
        try {
            spQuery.execute();
            res = (String) spQuery.getOutputParameterValue(4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            spQuery.unwrap(ProcedureOutputs.class)
                    .release();
        }
        return res;
    }


}
