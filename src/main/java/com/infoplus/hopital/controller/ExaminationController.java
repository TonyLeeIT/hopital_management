package com.infoplus.hopital.controller;

import com.infoplus.hopital.model.ExaminationEntity;
import com.infoplus.hopital.model.SearchRequest;
import com.infoplus.hopital.service.ExaminationService;
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
@Api(value = "Examination APIs")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @ApiOperation(value = "Xem danh sách Examination", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thành công"),
            @ApiResponse(code = 401, message = "Chưa xác thực"),
            @ApiResponse(code = 403, message = "Truy cập bị cấm"),
            @ApiResponse(code = 404, message = "Không tìm thấy")
    })
    @GetMapping("/api/v1/hopitalmanagement/examination")
    public ResponseEntity<Page<ExaminationEntity>> getAll(@RequestBody SearchRequest searchRequest){
        return ResponseEntity.ok(examinationService.getAll(searchRequest));
    }
}
