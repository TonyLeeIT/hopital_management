package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Service model")
public class ServiceEntity implements Serializable {

    @Id
    @Column(name = "name_service")
    private String nameService;

    @Column(name = "price" , nullable = false)
    private float price;

    @ManyToMany
    @JoinTable(name = "service_treatment", joinColumns = {
            @JoinColumn(name = "name_service", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_treatment", nullable = false)}
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TreatmentEntity> treatmentEntities;
}
