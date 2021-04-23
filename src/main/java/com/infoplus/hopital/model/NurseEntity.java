package com.infoplus.hopital.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "nurse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Nurse model")
public class NurseEntity implements Serializable {

    @Id
    @Column(name = "id_nurse")
    private String idNurse;

    @Column(name = "identity_number", nullable = false, unique = true)
    private String identityNumber;

    @Column(name = "name_nurse", nullable = false)
    private String nameNurse;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "exp", nullable = false)
    private int exp;

    @Column(name = "diploma", nullable = false)
    private String diploma;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "nurseEntity", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TreatmentEntity> treatmentEntities;
}
