package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "medicine")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Medicine model")
public class MedicineEntity implements Serializable {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "used_for", nullable = false)
    private String usedFor;

    @ManyToMany
    @JoinTable(name = "medicine_treatment", joinColumns = {
            @JoinColumn(name = "name_medicine", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_treatment", nullable = false)}
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TreatmentEntity> treatmentEntities;
}
