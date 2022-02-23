package ooppractice.global.common.exception;

import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    private ErrorCode errorCode;

    public GlobalException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public GlobalException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
