package ooppractice.domain.order.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class OrderNotFoundException extends GlobalException {

    public OrderNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public OrderNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
