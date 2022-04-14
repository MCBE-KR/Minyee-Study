package namsic.minyee.study.repository;

import namsic.minyee.study.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findByName(String name);
}
