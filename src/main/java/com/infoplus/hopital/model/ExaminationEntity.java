package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

//
//@NamedEntityGraph{
//    name = "examination-entity-graph-with-treatment-doctors-patients-"
//        }

@Entity
@Table(name = "examination" ,  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_examination"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Examination model")
public class ExaminationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Examination ID")
    @Column(name = "id_examination")
    private Integer idExamination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doctor" , nullable = false)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private  DoctorEntity doctorEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient" , nullable = false)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private  PatientEntity patientEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_disease" , nullable = false)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private DiseaseEntity diseaseEntity;

    @OneToMany(mappedBy = "examinationEntity", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TreatmentEntity> treatmentEntities;

    @Column(name = "at_time" , nullable = false)
    private Date atTime;
}
