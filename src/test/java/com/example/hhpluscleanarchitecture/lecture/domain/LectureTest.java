package com.example.hhpluscleanarchitecture.lecture.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LectureTest {

    @Test
    void 예약_인원이_찼으면_예외를_던진다() {
        //given
        List<Reservation> reservations = new ArrayList<>();
        Reservation newReservation = new Reservation(11, 1);
        for (int i = 0; i <10 ; i++) {
            reservations.add(new Reservation(i, 1));
        }
        Lecture lecture = new Lecture(LocalDateTime.now(), 10, reservations);

        // when & then
        assertThatThrownBy(() -> lecture.reserve(newReservation))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("강의 정원을 초과 했습니다");
    }

    @Test
    void 예약_인원이_충분하면_예약_성공() {
        //given
        List<Reservation> reservations = new ArrayList<>();
        Reservation newReservation = new Reservation(10, 1);
        for (int i = 0; i <9 ; i++) {
            reservations.add(new Reservation(i, 1));
        }
        Lecture lecture = new Lecture(LocalDateTime.now(), 10, reservations);

        // when
        lecture.reserve(newReservation);

        // then
        assertThat(reservations.size()).isEqualTo(10);
    }

    @Test
    void 중복_수강_신청_하면_예외를_던진다() {
        //given
        List<Reservation> reservations = new ArrayList<>();
        Reservation newReservation = new Reservation(8, 1);
        for (int i = 0; i <9 ; i++) {
            reservations.add(new Reservation(i, 1));
        }
        Lecture lecture = new Lecture(LocalDateTime.now(), 10, reservations);

        // when & then
        assertThatThrownBy(() -> lecture.reserve(newReservation))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("이미 수강신청 했습니다.");


    }

    @Test
    void 예약_인원이_아무도_없으면_예외를_던진다() {
        // given
        Lecture lecture = new Lecture(LocalDateTime.now(), 10, new ArrayList<>());

        // when & then
        assertThatThrownBy(() -> lecture.cancel(1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("수강 인원이 없습니다.");
    }

    @Test
    void 자신의_수강_내역이_없을_때_취소시_예외를_던진다() {
        // given
        List<Reservation> reservations = new ArrayList<>();
        Reservation newReservation = new Reservation(12, 1);
        for (int i = 0; i <10 ; i++) {
            reservations.add(new Reservation(i, 1));
        }
        Lecture lecture = new Lecture(LocalDateTime.now(), 10, reservations);

        // when & then
        assertThatThrownBy(() -> lecture.cancel(12))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("수강 신청 기록이 없습니다.");
    }

    @Test
    void 수강_신청_내역에_있을_때_취소_시_성공() {
        // given
        List<Reservation> reservations = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            reservations.add(new Reservation(i, 1));
        }
        Lecture lecture = new Lecture(LocalDateTime.now(), 10, reservations);

        // when
        lecture.cancel(8);

        //then
        assertThat(reservations.size()).isEqualTo(9);
        assertThat(reservations.stream()
               .anyMatch(reservation -> reservation.isMyReservation(8)))
                .isEqualTo(false);
    }

}