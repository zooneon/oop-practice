package ooppractice.domain.order.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    ORDER_CANCEL("주문 취소"),
    PAYMENT_STAND_BY("결제 대기"),
    ORDER_COMPLETE("주문 완료");

    private final String message;
}
