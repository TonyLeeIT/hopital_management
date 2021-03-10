package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.NurseEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.service.NurseService;
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
@CrossOrigin("*")
@RequestMapping("/")
@RequiredArgsConstructor
@Api(value = "Nurse APIs")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @ApiOperation(value = "Xem danh sách Nurse", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thành công"),
            @ApiResponse(code = 401, message = "Chưa xác thực"),
            @ApiResponse(code = 403, message = "Truy cập bị cấm"),
            @ApiResponse(code = 404, message = "Không tìm thấy")
    })
    @GetMapping("/api/v1/hopitalmanagement/nurse")
    public ResponseEntity<Page<NurseEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(nurseService.getAll(searchRequest));
    }
}
