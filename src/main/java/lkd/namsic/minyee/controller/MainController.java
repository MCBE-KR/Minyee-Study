package lkd.namsic.minyee.controller;

import lkd.namsic.minyee.dto.Response;
import lkd.namsic.minyee.dto.StudentDto;
import lkd.namsic.minyee.service.MainService;
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
    
    private final MainService mainService;
    
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
        log.info("addStudent {} {}", studentDto.getName(), studentDto.getSchoolName());
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    
}
