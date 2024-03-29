package com.example.hhpluscleanarchitecture.lecture.infrastructure;

import com.example.hhpluscleanarchitecture.lecture.domain.Reservation;

import java.util.Optional;

public interface ReservationRepository {

    Reservation save(Reservation entity);
    Reservation findByLectureId(final long lectureId);
    Reservation findByLectureIdAndUserId(final long lectureId, final long userId);
    Reservation findByUserId(final long userId);
}
