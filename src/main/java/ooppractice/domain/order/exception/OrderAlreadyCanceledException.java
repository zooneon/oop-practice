package ooppractice.domain.order.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class OrderAlreadyCanceledException extends GlobalException {

    public OrderAlreadyCanceledException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public OrderAlreadyCanceledException(ErrorCode errorCode) {
        super(errorCode);
    }
}
