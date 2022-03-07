package ooppractice.view.exception;

import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.GlobalException;

public class SelectionException extends GlobalException {

    public SelectionException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public SelectionException(ErrorCode errorCode) {
        super(errorCode);
    }
}
