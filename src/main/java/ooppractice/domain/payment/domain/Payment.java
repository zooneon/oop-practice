package ooppractice.domain.payment.domain;

import lombok.Builder;
import lombok.Getter;
import ooppractice.domain.order.domain.Order;
import ooppractice.domain.payment.exception.PaymentAlreadyCanceledException;
import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.common.repository.Entity;

import java.time.LocalDateTime;

@Getter
public class Payment extends Entity {

    private Long id;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;
    private PaymentType paymentType;
    private Order order;

    protected void setId(Long id) {
        this.id = id;
    }

    @Builder
    public Payment(PaymentStatus paymentStatus, LocalDateTime paymentDate, PaymentType paymentType, Order order) {
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.order = order;
    }

    public static Payment createPayment(LocalDateTime paymentDate, PaymentType paymentType, Order order) {
        return Payment.builder()
                .paymentStatus(PaymentStatus.PAYMENT_COMPLETE)
                .paymentDate(paymentDate)
                .paymentType(paymentType)
                .order(order)
                .build();
    }

    public void cancelPayment() {
        if (this.paymentStatus == PaymentStatus.PAYMENT_CANCEL) {
            throw new PaymentAlreadyCanceledException(ErrorCode.PAYMENT_ALREADY_CANCELED);
        }
        this.paymentStatus = PaymentStatus.PAYMENT_CANCEL;
    }
}
