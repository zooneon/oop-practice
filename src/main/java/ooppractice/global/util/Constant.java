package ooppractice.global.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constant {
    //view
    ERROR_CODE("에러코드: "),
    ENTER("\n");

    private final String value;
}
