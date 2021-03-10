package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Service model")
public class ServiceEntity {

    @Id
    @Column(name = "name_service")
    private String nameService;

    @Column(name = "price" , nullable = false)
    private float price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "service_treatment", joinColumns = {
            @JoinColumn(name = "name_service", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_treatment", nullable = false)}
    )
    @JsonIgnore
    private Set<TreatmentEntity> treatmentEntities;
}
