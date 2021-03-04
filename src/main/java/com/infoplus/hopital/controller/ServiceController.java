package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.ServiceEntity;
import com.infoplus.hopital.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ServiceController {

    @Autowired
    private Service service;

    @PutMapping("/api/v1/hopitalmanagement/service")
    public ResponseEntity<Page<ServiceEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(service.getAll(searchRequest));
    }
}
