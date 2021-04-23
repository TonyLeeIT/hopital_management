package com.infoplus.hopital.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Doctor model")
public class DoctorEntity implements Serializable {

    @Id
    @Column(name = "id_doctor")
    private String idDoctor;

    @Column(name = "identity_number", nullable = false, unique = true)
    private String identityNumber;

    @Column(name = "name_doctor", nullable = false)
    private String nameDoctor;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "exp", nullable = false)
    private int exp;

    @Column(name = "diploma", nullable = false)
    private String diploma;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "field", nullable = false)
    private String field;

    @OneToMany(mappedBy = "doctorEntity", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ExaminationEntity> examinationEntity;

    @OneToMany(mappedBy = "doctorEntity", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TreatmentEntity> treatmentEntities;
}
