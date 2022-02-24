package ooppractice.global.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooppractice.global.util.Constant;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    private String code;
    private String message;

    public ErrorResponse(final ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public static ErrorResponse of(final ErrorCode errorCode) {
        return new ErrorResponse(errorCode);
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        output.append(Constant.ERROR_CODE.getValue())
                .append(code)
                .append(Constant.ENTER.getValue())
                .append(message);
        return output.toString();
    }
}
