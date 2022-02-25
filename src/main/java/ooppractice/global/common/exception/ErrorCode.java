package ooppractice.global.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //common
    INVALID_INPUT_VALUE("C001", "잘못된 입력값입니다."),

    //user
    USER_NOT_FOUND("U001", "해당 사용자를 찾을 수 없습니다."),
    WRONG_PASSWORD("U002", "비밀번호가 일치하지 않습니다.");

    private final String code;
    private final String message;
}
