package com.test.wa.test.service;

import com.test.wa.test.dto.ObjectResponse;
import com.test.wa.test.dto.Response;
import com.test.wa.test.dto.StudentDto;
import com.test.wa.test.entity.City;
import com.test.wa.test.entity.School;
import com.test.wa.test.entity.Student;
import com.test.wa.test.exception.DataNotFoundException;
import com.test.wa.test.exception.DatabaseException;
import com.test.wa.test.repository.CityRepository;
import com.test.wa.test.repository.SchoolRepository;
import com.test.wa.test.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final CityRepository cityRepository;
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public Response post() {
        if (cityRepository.findAll().size() != 0) {
            return new Response();
        }

        City city = City.builder()
                .name("인천")
                .build();

        if (schoolRepository.findAll().size() != 0) {
            return new Response();
        }

        School school = School.builder()
                .name("초등학교")
                .city(city)
                .build();

        Student student1 = Student.builder()
                .name("길동홍")
                .age(15)
                .school(school)
                .build();
        Student student2 = Student.builder()
                .name("디질동")
                .age(16)
                .school(school)
                .build();

        cityRepository.save(city);
        schoolRepository.save(school);
        studentRepository.save(student1);
        studentRepository.save(student2);

        return new Response();

    }

    @Override
    @Transactional
    public Response addStudent(StudentDto studentDto) {
        String name = studentDto.getName();
        Integer age = studentDto.getAge();
        String schoolName = studentDto.getSchoolName();

        if (!StringUtils.hasLength(name)) {
            throw new DataNotFoundException("name");
        } else if (age == null) {
            throw new DataNotFoundException("age");
        } else if (!StringUtils.hasLength(schoolName)) {
            throw new DataNotFoundException("schoolName");
        }

        School school = schoolRepository.findByName(schoolName)
                .orElseThrow(() -> new DatabaseException("Unknown schoolName"));

        Student student = Student.builder()
                .name(name)
                .age(age)
                .school(school)
                .build();

        return new Response();
    }

    public ObjectResponse getStudent(String studentName) {
        Student student = studentRepository.findByName(studentName)
                .orElseThrow(() -> new DatabaseException("Unknown studentName"));

        return new ObjectResponse(student);
    }


}
