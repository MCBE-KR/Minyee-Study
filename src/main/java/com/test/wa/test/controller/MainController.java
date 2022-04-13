package com.test.wa.test.controller;

import com.test.wa.test.dto.GetStudentDto;
import com.test.wa.test.dto.ObjectResponse;
import com.test.wa.test.dto.Response;
import com.test.wa.test.dto.StudentDto;
import com.test.wa.test.entity.Student;
import com.test.wa.test.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private  final MainService mainService;

    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }

    @PostMapping("/post")
    public ResponseEntity<Response> post() {
        Response response = mainService.post();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("/add-student")
    public ResponseEntity<Response> addStudent(@RequestBody StudentDto studentDto) {
        Response response = mainService.addStudent(studentDto);
        log.info("add-student {} {}", studentDto.getName(), studentDto.getSchoolName());
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("/get-student")
    public ResponseEntity<Response> getStudent(@RequestBody GetStudentDto getStudentDto) {
        ObjectResponse response = mainService.getStudent(getStudentDto.getName());
        log.info("get-student {} ", getStudentDto.getName());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
