package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.TreatmentEntity;
import com.infoplus.hopital.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @PutMapping("/api/v1/hopitalmanagement/treatment")
    public ResponseEntity<Page<TreatmentEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(treatmentService.getAll(searchRequest));
    }
}
