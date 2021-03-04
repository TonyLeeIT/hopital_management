package com.infoplus.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "disease")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseEntity {

    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "diseaseEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ExaminationEntity> examinationEntity;
}
