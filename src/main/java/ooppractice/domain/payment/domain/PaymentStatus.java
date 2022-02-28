package ooppractice.domain.payment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    PAYMENT_COMPLETE("결제 완료"),
    PAYMENT_CANCEL("결제 취소");

    private final String message;
}