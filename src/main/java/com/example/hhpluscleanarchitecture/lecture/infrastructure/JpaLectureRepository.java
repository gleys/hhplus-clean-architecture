package com.example.hhpluscleanarchitecture.lecture.infrastructure;

import com.example.hhpluscleanarchitecture.lecture.domain.Lecture;
import org.springframework.data.repository.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface JpaLectureRepository extends Repository<Lecture, Long> {
    Optional<Lecture> findById(final long id);
    List<Lecture> findAll();
}
