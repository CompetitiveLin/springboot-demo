package com.example.demo.service;

public interface CheckinService {
    void checkin(String username);

    boolean isCheckin(String username);

    void lateCheckin(String username, String date);

    int checkinMonthlyCount(String username, String date);

    int checkinContinuouslyCount(String username);
}
