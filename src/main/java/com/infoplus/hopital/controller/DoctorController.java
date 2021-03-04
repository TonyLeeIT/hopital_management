package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.DoctorEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PutMapping("/api/v1/hopitalmanagement/doctor")
    public ResponseEntity<Page<DoctorEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(doctorService.getAll(searchRequest));
    }
}
