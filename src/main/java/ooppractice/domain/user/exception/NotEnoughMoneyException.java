package ooppractice.domain.user.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class NotEnoughMoneyException extends GlobalException {

    public NotEnoughMoneyException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NotEnoughMoneyException(ErrorCode errorCode) {
        super(errorCode);
    }
}
