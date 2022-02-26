package ooppractice.global.common.exception;

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

    //order
    ORDER_NOT_FOUND("OR001", "해당 주문 정보를 찾을 수 없습니다."),

    //orderitem
    OUT_OF_STOCK("OT001","상품의 재고가 부족합니다."),
    SOLD_OUT("OT002", "매진된 상품입니다."),

    //item
    ITEM_NOT_FOUND("IT001","해당 상품을 찾을 수 없습니다."),

    //category
    CATEGORY_NOT_FOUND("CT001", "해당 카테고리를 찾을 수 없습니다.");

    private final String code;
    private final String message;
}
