package ooppractice.global.exception;

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
        StringBuilder output = new StringBuilder();
        output.append(Constant.ERROR_CODE)
                .append(Constant.SEMICOLON)
                .append(Constant.BLANK)
                .append(code)
                .append(Constant.NEXT_LINE)
                .append(message);
        return output.toString();
    }
}
