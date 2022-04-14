package namsic.minyee.study.service;

import namsic.minyee.study.dto.ObjectResponse;
import namsic.minyee.study.dto.Response;
import namsic.minyee.study.dto.StudentPostRequest;
import org.springframework.data.domain.Pageable;

public interface MainService {

    Response addStudent(StudentPostRequest studentPostRequest);
    ObjectResponse getStudent(String studentName);
    ObjectResponse getPaging(Pageable pageable);
    
}
