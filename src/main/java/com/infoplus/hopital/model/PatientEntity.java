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
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {

    @Id
    @Column(name = "id_patient")
    private String idPatient;

    @Column(name = "identity_number" , nullable = false , unique = true)
    private String identityNumber;

    @Column(name = "name_patient" , nullable = false)
    private String namePatient;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "address" , nullable = false)
    private String address;

    @Column(name = "phone" , nullable = false)
    private String phone;

    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "patientEntity" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ExaminationEntity> examinationEntity;
}
