package com.example.demo.common.time;

import org.springframework.test.util.ReflectionTestUtils;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class TestSystemTime {
    private static final String CLOCK_FIELD_NAME = "CLOCK";

    public static void fix(final Instant time) {
        var clock = Clock.fixed(time, ZoneId.systemDefault());
        ReflectionTestUtils.setField(SystemTime.class, CLOCK_FIELD_NAME, clock);
    }

    public static void reset() {
        ReflectionTestUtils.setField(SystemTime.class, CLOCK_FIELD_NAME, SystemTime.DEFAULT_CLOCK);
    }
}
