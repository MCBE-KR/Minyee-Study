package com.test.wa.test.dto;

import com.test.wa.test.entity.Student;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentResponse extends AbstractResponse {

    Long id;
    String name;
    Integer age;
    String schoolName;

    static StudentResponse create(Student student) {
        return new StudentResponse(student.getId(), student.getName(), student.getAge(), student.getSchool().getName());
    }
}
