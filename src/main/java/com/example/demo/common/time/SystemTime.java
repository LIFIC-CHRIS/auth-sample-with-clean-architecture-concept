package com.example.demo.common.time;

import java.time.Clock;
import java.time.Instant;

public class SystemTime {
    public static final Clock DEFAULT_CLOCK = Clock.systemUTC();

    // changeable for testing
    private static Clock CLOCK = DEFAULT_CLOCK;

    public static Instant now() {
        return Instant.now(CLOCK);
    }
}
