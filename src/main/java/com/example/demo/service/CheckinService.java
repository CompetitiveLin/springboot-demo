package com.example.demo.service;

public interface CheckinService {
    void checkin(String username);

    String checkinMonthlyList(String username, String date);

    void lateCheckin(String username, String date);

    int checkinMonthlyCount(String username, String date);

    int checkinContinuouslyCount(String username);

    long rank(String username);
}
