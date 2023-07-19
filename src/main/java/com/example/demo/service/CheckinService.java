package com.example.demo.service;

import javafx.util.Pair;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

public interface CheckinService {
    void checkin(String username);

    String checkinMonthlyList(String username, String date);

    void lateCheckin(String username, String date);

    int checkinMonthlyCount(String username, String date);

    int checkinContinuouslyCount(String username);

    Set<Pair<String, String>> rankTop100();
}
