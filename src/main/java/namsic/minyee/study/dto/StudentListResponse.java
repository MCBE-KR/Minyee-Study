package namsic.minyee.study.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import namsic.minyee.study.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentListResponse extends AbstractResponse {
    
    List<StudentResponse> studentResponseList;
    
    static StudentListResponse create(List<Student> studentResponseList) {
        return new StudentListResponse(studentResponseList.stream()
            .map(StudentResponse::create)
            .collect(Collectors.toList()));
    }
    
}
