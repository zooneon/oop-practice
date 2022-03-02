package ooppractice.domain.payment.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class PaymentAlreadyCanceledException extends GlobalException {

    public PaymentAlreadyCanceledException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public PaymentAlreadyCanceledException(ErrorCode errorCode) {
        super(errorCode);
    }
}
