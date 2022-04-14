package namsic.minyee.study.service;

import lombok.RequiredArgsConstructor;
import namsic.minyee.study.dto.ObjectResponse;
import namsic.minyee.study.dto.Response;
import namsic.minyee.study.dto.StudentPostRequest;
import namsic.minyee.study.dto.StudentResponse;
import namsic.minyee.study.entity.School;
import namsic.minyee.study.entity.Student;
import namsic.minyee.study.exception.DataNotFoundException;
import namsic.minyee.study.exception.DatabaseException;
import namsic.minyee.study.repository.SchoolRepository;
import namsic.minyee.study.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Response addStudent(StudentPostRequest studentPostRequest) {
        String name = studentPostRequest.getName();
        Integer age = studentPostRequest.getAge();
        String schoolName = studentPostRequest.getSchoolName();
        
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
    
    public ObjectResponse getStudent(String studentName) {
        Student student = studentRepository.findByName(studentName)
            .orElseThrow(() -> new DatabaseException("Unknown studentName"));
        
        return new ObjectResponse(student);
    }
    
    @Override
    public ObjectResponse getPaging(Pageable pageable) {
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return new ObjectResponse(studentPage.getContent());
    }
    
}
