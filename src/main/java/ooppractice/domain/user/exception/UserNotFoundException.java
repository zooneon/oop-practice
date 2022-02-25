package ooppractice.domain.user.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class UserNotFoundException extends GlobalException {

    public UserNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
