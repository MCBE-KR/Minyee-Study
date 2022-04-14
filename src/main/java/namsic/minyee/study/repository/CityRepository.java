package namsic.minyee.study.repository;

import namsic.minyee.study.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
