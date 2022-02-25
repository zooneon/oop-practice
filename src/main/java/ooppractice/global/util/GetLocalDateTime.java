package ooppractice.global.util;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetLocalDateTime {

    private final LocalDateTime now;

    public GetLocalDateTime() {
        now = LocalDateTime.now();
    }
}
