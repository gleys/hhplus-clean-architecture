package com.example.hhpluscleanarchitecture.lecture.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(exclude = {"id", "createdAt"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;

    private long lectureId;

    private long userId;

    private LocalDateTime createdAt;

    public Reservation(final long userId, final long lectureId, final LocalDateTime now) {
        this.userId = userId;
        this.lectureId = lectureId;
        this.createdAt = now;
    }

    public boolean isMyReservation(final long userId) {
        return this.userId == userId;
    }
}
