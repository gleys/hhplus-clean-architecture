package com.example.hhpluscleanarchitecture.lecture.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;

    private long lectureId;

    private long userId;

    public Reservation(final long userId, final long lectureId) {
        this.userId = userId;
        this.lectureId = lectureId;
    }

    public boolean isMyReservation(final long userId) {
        return this.userId == userId;
    }
}
