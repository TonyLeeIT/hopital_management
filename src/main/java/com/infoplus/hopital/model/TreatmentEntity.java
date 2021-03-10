package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "treatment" ,  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_treatment"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Treatment model")
public class TreatmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Treatment ID")
    @Column(name = "id_treatment")
    private Integer idTreatment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_examination",nullable = false)
    private ExaminationEntity examinationEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nurse",nullable = false)
    private  NurseEntity nurseEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doctor_cure",nullable = false)
    private DoctorEntity doctorEntity;

    @ManyToMany(fetch = FetchType.EAGER , mappedBy = "treatmentEntities")
    @JsonIgnore
    private Set<MedicineEntity> medicineEntities;

    @ManyToMany(fetch = FetchType.EAGER , mappedBy = "treatmentEntities")
    @JsonIgnore
    private Set<ServiceEntity> serviceEntities;
}
