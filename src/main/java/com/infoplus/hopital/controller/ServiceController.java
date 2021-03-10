package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.model.ServiceEntity;
import com.infoplus.hopital.service.Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
@RequiredArgsConstructor
@Api(value = "Service APIs")
public class ServiceController {

    @Autowired
    private Service service;

    @ApiOperation(value = "Xem danh sách Service", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thành công"),
            @ApiResponse(code = 401, message = "Chưa xác thực"),
            @ApiResponse(code = 403, message = "Truy cập bị cấm"),
            @ApiResponse(code = 404, message = "Không tìm thấy")
    })
    @GetMapping("/api/v1/hopitalmanagement/service")
    public ResponseEntity<Page<ServiceEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(service.getAll(searchRequest));
    }
}
