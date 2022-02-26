package ooppractice.domain.orderitem.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class SoldOutException extends GlobalException {

    public SoldOutException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public SoldOutException(ErrorCode errorCode) {
        super(errorCode);
    }
}
