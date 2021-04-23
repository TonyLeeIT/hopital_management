package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "disease")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Disease model")
public class DiseaseEntity implements Serializable {

    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "diseaseEntity", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ExaminationEntity> examinationEntity;
}
