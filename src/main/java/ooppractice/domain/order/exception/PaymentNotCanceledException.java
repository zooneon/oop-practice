package ooppractice.domain.order.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class PaymentNotCanceledException extends GlobalException {

    public PaymentNotCanceledException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public PaymentNotCanceledException(ErrorCode errorCode) {
        super(errorCode);
    }
}
