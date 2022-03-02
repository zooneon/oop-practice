package ooppractice.domain.payment.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class PaymentNotFoundException extends GlobalException {

    public PaymentNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public PaymentNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
