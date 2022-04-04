package lkd.namsic.minyee.service;

import lkd.namsic.minyee.dto.Response;
import lkd.namsic.minyee.dto.StudentDto;
import lkd.namsic.minyee.entity.School;
import lkd.namsic.minyee.entity.Student;
import lkd.namsic.minyee.exception.DataNotFoundException;
import lkd.namsic.minyee.exception.DatabaseException;
import lkd.namsic.minyee.repository.SchoolRepository;
import lkd.namsic.minyee.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;
    
    @Override
    @Transactional
    public Response post() {
        if(schoolRepository.findAll().size() != 0) {
            return new Response();
        }
        
        School school = School.builder().name("초등학교").build();
        
        Student student1 = Student.builder()
            .name("홍길동")
            .age(15)
            .school(school)
            .build();
        Student student2 = Student.builder()
            .name("고길동")
            .age(16)
            .school(school)
            .build();
    
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
        
        if(!StringUtils.hasLength(name)) {
            throw new DataNotFoundException("name");
        } else if(age == null) {
            throw new DataNotFoundException("age");
        } else if(!StringUtils.hasLength(schoolName)) {
            throw new DataNotFoundException("schoolName");
        }
        
        School school = schoolRepository.findByName(schoolName)
            .orElseThrow(() -> new DatabaseException("Unknown schoolName"));
        
        Student student = Student.builder()
            .name(name)
            .age(age)
            .school(school)
            .build();
        studentRepository.save(student);
        
        return new Response();
    }
    
}
