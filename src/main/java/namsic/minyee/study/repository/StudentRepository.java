package namsic.minyee.study.repository;

import namsic.minyee.study.dto.StudentResponse;
import namsic.minyee.study.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByName(String name);
//    Page<StudentResponse> findAll(Pageable pageable);
    
}
