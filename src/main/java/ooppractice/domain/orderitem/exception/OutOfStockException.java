package ooppractice.domain.orderitem.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class OutOfStockException extends GlobalException {

    public OutOfStockException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public OutOfStockException(ErrorCode errorCode) {
        super(errorCode);
    }
}
