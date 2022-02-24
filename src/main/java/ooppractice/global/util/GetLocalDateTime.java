package ooppractice.global.util;

import java.time.LocalDateTime;

public class GetLocalDateTime {

    private final LocalDateTime now;

    public GetLocalDateTime() {
        now = LocalDateTime.now();
    }

    public static LocalDateTime getNow() {
        return new GetLocalDateTime().now;
    }
}
