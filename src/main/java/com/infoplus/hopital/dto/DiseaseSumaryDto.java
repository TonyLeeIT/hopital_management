package com.infoplus.hopital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DiseaseSumaryDto {

    private String namePatient;
    private String nameDisease;
    private Date atTime;
    private Long numOfPatient;

}
