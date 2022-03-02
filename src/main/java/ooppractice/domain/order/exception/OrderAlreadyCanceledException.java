package ooppractice.domain.order.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class OrderAlreadyCanceledException extends GlobalException {

    public OrderAlreadyCanceledException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public OrderAlreadyCanceledException(ErrorCode errorCode) {
        super(errorCode);
    }
}
