package ooppractice.domain.user.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class WrongPasswordException extends GlobalException {

    public WrongPasswordException(ErrorCode errorCode) {
        super(errorCode);
    }

    public WrongPasswordException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
