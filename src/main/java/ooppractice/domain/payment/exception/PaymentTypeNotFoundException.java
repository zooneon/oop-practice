package ooppractice.domain.payment.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class PaymentTypeNotFoundException extends GlobalException {

    public PaymentTypeNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public PaymentTypeNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
