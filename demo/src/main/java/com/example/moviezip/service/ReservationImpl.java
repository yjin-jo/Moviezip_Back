package com.example.moviezip.service;

import com.example.moviezip.dao.mybatis.MybatisReservationDao;
import com.example.moviezip.domain.Reservation;

public class ReservationImpl {
    private final MybatisReservationDao mybatisReservationDao;
    public ReservationImpl(MybatisReservationDao mybatisReservationDao) {
        this.mybatisReservationDao = mybatisReservationDao;
    }
    public void insertReservation(Reservation reservation) { mybatisReservationDao.insertReservation(reservation);}
}