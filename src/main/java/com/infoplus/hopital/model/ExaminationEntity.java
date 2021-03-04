package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "examination" ,  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_examination"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examination")
    private Integer idExamination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doctor" , nullable = false)
    private  DoctorEntity doctorEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_patient" , nullable = false)
    private  PatientEntity patientEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name_disease" , nullable = false)
    private DiseaseEntity diseaseEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "examinationEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TreatmentEntity> treatmentEntities;

    @Column(name = "at_time" , nullable = false)
    private Date atTime;
}
