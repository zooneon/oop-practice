package ooppractice.global.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //common
    INVALID_INPUT_VALUE("C001", "잘못된 입력값입니다.");

    private final String code;
    private final String message;
}
