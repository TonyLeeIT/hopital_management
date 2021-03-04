package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.ExaminationEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @PutMapping("/api/v1/hopitalmanagement/examination")
    public ResponseEntity<Page<ExaminationEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(examinationService.getAll(searchRequest));
    }
}
