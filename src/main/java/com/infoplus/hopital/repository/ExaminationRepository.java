package com.infoplus.hopital.repository;

import com.infoplus.hopital.dto.DiseaseSumaryDto;
import com.infoplus.hopital.model.ExaminationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ExaminationRepository extends PagingAndSortingRepository<ExaminationEntity, Integer> {

    @Query("select distinct  new com.infoplus.hopital.dto.DiseaseSumaryDto(p.namePatient , e.diseaseEntity.name ,e.atTime, count(e.idExamination) ) " +
            "from ExaminationEntity e inner join  PatientEntity p on e.patientEntity.idPatient = p.idPatient " +
            "where DATEDIFF ('2020-07-31', e.atTime) < 31  " +
            "group by name_patient , name_disease " +
            "order by count(e.idExamination) desc")
    Page<DiseaseSumaryDto> getPatientSumary(Pageable pageable);
}
