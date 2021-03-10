package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.DoctorEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.service.DoctorService;
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
@Api(value = "Doctor APIs")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @ApiOperation(value = "Xem danh sách Doctor", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thành công"),
            @ApiResponse(code = 401, message = "Chưa xác thực"),
            @ApiResponse(code = 403, message = "Truy cập bị cấm"),
            @ApiResponse(code = 404, message = "Không tìm thấy")
    })
    @GetMapping("/api/v1/hopitalmanagement/doctor")
    public ResponseEntity<Page<DoctorEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(doctorService.getAll(searchRequest));
    }

    @ApiOperation(value = "Xem danh sách Doctor", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thành công"),
            @ApiResponse(code = 401, message = "Chưa xác thực"),
            @ApiResponse(code = 403, message = "Truy cập bị cấm"),
            @ApiResponse(code = 404, message = "Không tìm thấy")
    })
    @GetMapping("/api/v1/hopitalmanagement/doctor/{idDoctor}/{nameDoctor}")
    public ResponseEntity<Page<DoctorEntity>> getByIdAndName(@PathVariable("idDoctor") String idDOctor ,
                                                             @PathVariable("nameDoctor") String nameDoctor,
                                                             @RequestBody SearchRequest searchRequest   ){
        return ResponseEntity.ok(doctorService.getByIdAndName(idDOctor , nameDoctor , searchRequest));
    }
}
