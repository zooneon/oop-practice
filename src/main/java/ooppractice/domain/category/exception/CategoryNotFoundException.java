package ooppractice.domain.category.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class CategoryNotFoundException extends GlobalException {

    public CategoryNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public CategoryNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
