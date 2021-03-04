package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medicine")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "used_for", nullable = false)
    private String usedFor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "medicine_treatment", joinColumns = {
            @JoinColumn(name = "name_medicine", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_treatment", nullable = false)}
    )
    @JsonIgnore
    private Set<TreatmentEntity> treatmentEntities;
}
