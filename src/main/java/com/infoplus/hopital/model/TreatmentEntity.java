package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "treatment", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_treatment"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Treatment model")
public class TreatmentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Treatment ID")
    @Column(name = "id_treatment")
    private Integer idTreatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examination", nullable = false)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ExaminationEntity examinationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nurse", nullable = false)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private NurseEntity nurseEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor_cure", nullable = false)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private DoctorEntity doctorEntity;

    @ManyToMany(mappedBy = "treatmentEntities")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<MedicineEntity> medicineEntities;

    @ManyToMany(mappedBy = "treatmentEntities")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ServiceEntity> serviceEntities;
}
