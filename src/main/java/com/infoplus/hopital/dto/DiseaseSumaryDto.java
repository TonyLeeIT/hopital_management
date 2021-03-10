package com.infoplus.hopital.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class DiseaseSumaryDto {

    private String namePatient;
    private String nameDisease;
    private Date atTime;
    private Long numOfPatient;
}
