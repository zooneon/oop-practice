package ooppractice.domain.payment.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class PaymentNotFoundException extends GlobalException {

    public PaymentNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public PaymentNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
