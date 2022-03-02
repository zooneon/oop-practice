package ooppractice.domain.item.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class ItemNotFoundException extends GlobalException {

    public ItemNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ItemNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
