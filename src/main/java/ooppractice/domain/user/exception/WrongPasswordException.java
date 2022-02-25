package ooppractice.domain.user.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class WrongPasswordException extends GlobalException {

    public WrongPasswordException(ErrorCode errorCode) {
        super(errorCode);
    }

    public WrongPasswordException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
