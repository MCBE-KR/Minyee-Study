package lkd.namsic.minyee.repository;

import lkd.namsic.minyee.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
