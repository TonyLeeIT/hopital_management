package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.NurseEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @PutMapping("/api/v1/hopitalmanagement/nurse")
    public ResponseEntity<Page<NurseEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(nurseService.getAll(searchRequest));
    }
}
