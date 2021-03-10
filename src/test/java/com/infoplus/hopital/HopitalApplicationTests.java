package com.infoplus.hopital;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoplus.hopital.repository.DoctorRepository;
import com.infoplus.hopital.repository.ExaminationRepository;
import com.infoplus.hopital.repository.TreatmentRepository;
import com.infoplus.hopital.repository.custom.TreatmentRepositoryCustom;
import com.infoplus.hopital.service.DoctorService;
import com.infoplus.hopital.service.TreatmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;


@SpringBootTest
class HopitalApplicationTests {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    ExaminationRepository examinationRepository;

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    TreatmentService treatmentService;

    @Autowired
    DoctorService doctorService;


    @Test
    @Modifying
    @Transactional
    void contextLoads() throws JsonProcessingException, ParseException {
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
//        List<String> list = new ArrayList<>();
//        Page<DiseaseSumaryDto> results = examinationRepository.getPatientSumary(pageable);
//
//        for(DiseaseSumaryDto item : results){
//
//            list.add(Util.convertIntoTimeStamp(item.getAtTime()));
//        }
//

//        Stream<String> convert = examinationRepository.getAtTime().map(item -> (Util.convertIntoTimeStamp(item)));
//
//        System.out.println(mapper.writeValueAsString(convert.toArray()));

        //System.out.println(treatmentRepositoryCustom.pushTreatmentDownDatabase("YT07",Util.covertStringToDate("2021-03-05"),true));

 //       treatmentService.callProcedureTreatment("YT09",true);




    }

}
