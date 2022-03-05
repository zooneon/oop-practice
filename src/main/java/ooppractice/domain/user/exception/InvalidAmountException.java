package ooppractice.domain.user.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class InvalidAmountException extends GlobalException {

    public InvalidAmountException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InvalidAmountException(ErrorCode errorCode) {
        super(errorCode);
    }
}
