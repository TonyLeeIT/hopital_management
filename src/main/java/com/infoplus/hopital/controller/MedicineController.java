package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.MedicineEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PutMapping("/api/v1/hopitalmanagement/medicine")
    public ResponseEntity<Page<MedicineEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(medicineService.getAll(searchRequest));
    }
}