package com.test.wa.test.service;

import com.test.wa.test.dto.ObjectResponse;
import com.test.wa.test.dto.Response;
import com.test.wa.test.dto.StudentDto;
import com.test.wa.test.entity.Student;

public interface MainService {

    Response post();

    Response addStudent(StudentDto studentDto);

    ObjectResponse getStudent(String studentName);

}
