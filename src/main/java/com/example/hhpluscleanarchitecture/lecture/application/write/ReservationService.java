package com.example.hhpluscleanarchitecture.lecture.application.write;

import com.example.hhpluscleanarchitecture.lecture.application.read.LectureReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final LectureReadService lectureReadService;

}
