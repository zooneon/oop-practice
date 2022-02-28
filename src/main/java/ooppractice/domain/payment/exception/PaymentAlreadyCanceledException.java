package ooppractice.domain.payment.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class PaymentAlreadyCanceledException extends GlobalException {

    public PaymentAlreadyCanceledException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public PaymentAlreadyCanceledException(ErrorCode errorCode) {
        super(errorCode);
    }
}
