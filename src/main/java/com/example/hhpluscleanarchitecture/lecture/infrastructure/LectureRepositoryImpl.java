package com.example.hhpluscleanarchitecture.lecture.infrastructure;

import com.example.hhpluscleanarchitecture.lecture.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class LectureRepositoryImpl implements LectureRepository {
    private final JpaLectureRepository lectureRepository;

    @Override
    public Lecture findById(final long id) {
        return lectureRepository.findById(id)
                       .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }


}
