package com.infoplus.hopital.repository.custom;

import com.infoplus.hopital.model.DoctorEntity;


import java.util.List;

public interface DoctorCustomRepository  {

    List<DoctorEntity> findDoctorsByIdAndName(String idDoctor , String nameDoctor);
}
