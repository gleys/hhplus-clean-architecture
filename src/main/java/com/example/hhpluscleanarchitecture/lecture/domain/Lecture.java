package com.example.hhpluscleanarchitecture.lecture.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Lecture {

    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime startedAt;
    private long capacity;
    @OneToMany
    private List<Reservation> reservations;

    public void reserve(final Reservation reservation) {
        if (reservations.size() >= capacity) {
            throw new RuntimeException("강의 정원을 초과 했습니다");
        }
        isAlreadyReserve(reservation);
        reservations.add(reservation);
    }

    public void cancel(final long userId) {
        isEmptyReservation();
        if (getTargetReservation(userId).isEmpty()) throw new RuntimeException("수강 신청 기록이 없습니다.");

        reservations.remove(getTargetReservation(userId).get());
    }


    public Lecture(final LocalDateTime startedAt, final long capacity, final List<Reservation> reservations) {
        this.startedAt = startedAt;
        this.capacity = capacity;
        this.reservations = reservations;
    }

    private void isEmptyReservation() {
        if (this.reservations.isEmpty()) throw new RuntimeException("수강 인원이 없습니다.");
    }

    private void isAlreadyReserve(final Reservation newReservation) {
        boolean isMatch = this.reservations.stream()
                                  .anyMatch(reservation -> reservation.equals(newReservation));
        if (isMatch) throw new RuntimeException("이미 수강신청 했습니다.");
    }

    private Optional<Reservation> getTargetReservation(final long userId) {
        return this.reservations.stream()
                  .filter(lecture -> lecture.isMyReservation(userId))
                  .findFirst();
    }
}