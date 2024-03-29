package com.example.hhpluscleanarchitecture.lecture.application.read;

import com.example.hhpluscleanarchitecture.lecture.domain.Lecture;
import com.example.hhpluscleanarchitecture.lecture.infrastructure.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureReadService {

    private final LectureRepository lectureRepository;

    public Lecture getLecture(final long lectureId) {
        return lectureRepository.findById(lectureId);
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }


}
