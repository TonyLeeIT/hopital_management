package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.PatientEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PutMapping("/api/v1/hopitalmanagement/patient")
    public ResponseEntity<Page<PatientEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(patientService.getAll(searchRequest));
    }
}
