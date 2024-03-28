package com.example.hhpluscleanarchitecture.lecture.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;

    private long userId;

    public Reservation(final long userId) {
        this.userId = userId;
    }

    public boolean isMyReservation(final long userId) {
        return this.userId == userId;
    }
}
