package namsic.minyee.study.controller;

import namsic.minyee.study.dto.StudentGetRequest;
import namsic.minyee.study.dto.ObjectResponse;
import namsic.minyee.study.dto.Response;
import namsic.minyee.study.dto.StudentPostRequest;
import namsic.minyee.study.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @PostMapping("/add-student")
    public ResponseEntity<Response> addStudent(@RequestBody StudentPostRequest studentPostRequest) {
        Response response = mainService.addStudent(studentPostRequest);
        log.info("add-student {} {}", studentPostRequest.getName(), studentPostRequest.getSchoolName());
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("/get-student")
    public ResponseEntity<ObjectResponse> getStudent(@RequestBody StudentGetRequest studentGetRequest) {
        ObjectResponse response = mainService.getStudent(studentGetRequest.getName());
        log.info("get-student {} ", studentGetRequest.getName());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    
    @GetMapping("/page")
    public ResponseEntity<ObjectResponse> getPaging(@PageableDefault(size = 20) Pageable pageable) {
        ObjectResponse response = mainService.getPaging(pageable);
        log.info("get-paging {}", pageable.getPageNumber());
    
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    
}
