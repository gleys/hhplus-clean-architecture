package com.example.hhpluscleanarchitecture.lecture.infrastructure;

import com.example.hhpluscleanarchitecture.lecture.domain.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReservationRepositoryImpl implements ReservationRepository{
    private final JpaReservationRepository reservationRepository;
    @Override
    public Reservation save(final Reservation entity) {
        return reservationRepository.save(entity);
    }

    @Override
    public Reservation findByLectureId(final long lectureId) {
        return null;
    }

    @Override
    public Reservation findByLectureIdAndUserId(final long lectureId, final long userId) {
        return null;
    }

    @Override
    public Reservation findByUserId(final long userId) {
        return null;
    }
}
