package com.infoplus.hopital;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoplus.hopital.dto.DiseaseSumaryDto;
import com.infoplus.hopital.repository.DoctorRepository;
import com.infoplus.hopital.repository.ExaminationRepository;
import com.infoplus.hopital.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class HopitalApplicationTests {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    ExaminationRepository examinationRepository;


    @Test
    @Transactional(readOnly = true)
    void contextLoads() throws JsonProcessingException {
        Pageable pageable = PageRequest.of(0 , 10);
        //doctorRepository.findAll(pageable);

        ObjectMapper mapper = new ObjectMapper();
//        String result = mapper.writeValueAsString(examinationRepository.findAll());
//        System.out.println(result);
//        AtomicReference<String> result = null;
//        Stream<Object> data = examinationRepository.getPatientSumary();
//        data.map(item -> {
//            try {
//                System.out.println(mapper.writeValueAsString(item));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            return result;
//        });

//        List<Object[]> results = examinationRepository.getPatientSumary();
//        for (Object[] item : results){
//            System.out.println(item[0] + "       " + item[1] +"     " +item[2] +"   "+ item[3]);
//        }
        List<String> list = new ArrayList<>();
        Page<DiseaseSumaryDto> results = examinationRepository.getPatientSumary(pageable);

        for(DiseaseSumaryDto item : results){

            list.add(Util.convertIntoTimeStamp(item.getAtTime()));
        }

        System.out.println(mapper.writeValueAsString(results));
    }

}
