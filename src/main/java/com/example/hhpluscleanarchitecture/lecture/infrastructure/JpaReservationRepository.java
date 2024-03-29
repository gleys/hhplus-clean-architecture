package com.example.hhpluscleanarchitecture.lecture.infrastructure;


import com.example.hhpluscleanarchitecture.lecture.domain.Reservation;
import org.springframework.data.repository.Repository;

public interface JpaReservationRepository extends Repository<Reservation, Long> {
    Reservation save(Reservation entity);
}
