package ooppractice.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //common
    INVALID_INPUT_VALUE("C001", "잘못된 입력값입니다."),

    //user
    USER_NOT_FOUND("U001", "해당 사용자를 찾을 수 없습니다."),
    WRONG_PASSWORD("U002", "비밀번호가 일치하지 않습니다."),
    INVALID_AMOUNT("U003", "입금액은 0원보다 커야합니다."),

    //order
    ORDER_NOT_FOUND("OR001", "해당 주문 정보를 찾을 수 없습니다."),
    PAYMENT_NOT_CANCELED("OR002", "결제가 취소되지 않았습니다."),
    ORDER_ALREADY_CANCELED("OR003", "이미 취소된 주문입니다."),

    //order item
    OUT_OF_STOCK("OT001","상품의 재고가 부족합니다."),
    SOLD_OUT("OT002", "매진된 상품입니다."),

    //item
    ITEM_NOT_FOUND("IT001","해당 상품을 찾을 수 없습니다."),

    //category
    CATEGORY_NOT_FOUND("CT001", "해당 카테고리를 찾을 수 없습니다."),

    //payment
    PAYMENT_NOT_FOUND("P001", "해당 결제 정보를 찾을 수 없습니다."),
    NOT_ENOUGH_MONEY("P002", "입금액이 부족합니다."),
    PAYMENT_ALREADY_CANCELED("P003", "이미 취소된 결제입니다."),
    PAYMENT_TYPE_NOT_FOUND("P004", "해당 결제 방법은 존재하지 않습니다.");

    private final String code;
    private final String message;
}
