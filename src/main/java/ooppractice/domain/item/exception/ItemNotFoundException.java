package ooppractice.domain.item.exception;

import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.exception.GlobalException;

public class ItemNotFoundException extends GlobalException {

    public ItemNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ItemNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
