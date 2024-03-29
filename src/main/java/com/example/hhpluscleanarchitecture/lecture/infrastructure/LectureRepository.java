package com.example.hhpluscleanarchitecture.lecture.infrastructure;

import com.example.hhpluscleanarchitecture.lecture.domain.Lecture;

import java.util.List;

public interface LectureRepository {
    Lecture findById(final long id);
    List<Lecture> findAll();

}
