package namsic.minyee.study;

import lombok.RequiredArgsConstructor;
import namsic.minyee.study.entity.City;
import namsic.minyee.study.entity.School;
import namsic.minyee.study.entity.Student;
import namsic.minyee.study.repository.CityRepository;
import namsic.minyee.study.repository.SchoolRepository;
import namsic.minyee.study.repository.StudentRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class StudyApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {
    
    private final CityRepository cityRepository;
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;
    
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Random random = new Random();
        
        City city = City.builder().name("서울").build();
        cityRepository.save(city);
    
        School school = School.builder()
            .name("학교")
            .city(city)
            .build();
        schoolRepository.save(school);
        
        Student student;
        for(int i = 1; i <= 100; i++) {
            student = Student.builder()
                .name("학생_" + i)
                .age(random.nextInt(10) + 8)
                .school(school)
                .build();
            studentRepository.save(student);
        }
    }
    
}
