package ooppractice.domain.payment.domain;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.payment.exception.PaymentAlreadyCanceledException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {

    @Test
    void createPayment() {
        //given
        LocalDateTime paymentDate = LocalDateTime.of(2022, 2, 27, 0, 0, 0);
        PaymentType paymentType = PaymentType.BM_PAY;
        Order order = Order.builder().build();
        //when
        Payment payment = Payment.createPayment(paymentDate, paymentType, order);
        //then
        assertThat(payment.getPaymentDate()).isEqualTo(paymentDate);
        assertThat(payment.getPaymentStatus()).isEqualTo(PaymentStatus.PAYMENT_COMPLETE);
        assertThat(payment.getPaymentType()).isEqualTo(paymentType);
        assertThat(payment.getOrder()).isEqualTo(order);
    }

    @Test
    void cancelPayment() {
        //given
        Payment payment = Payment.builder().paymentStatus(PaymentStatus.PAYMENT_COMPLETE).build();
        Payment canceledPayment = Payment.builder().paymentStatus(PaymentStatus.PAYMENT_CANCEL).build();
        //when
        payment.cancelPayment();
        //then
        assertThat(payment.getPaymentStatus()).isEqualTo(PaymentStatus.PAYMENT_CANCEL);
        assertThrows(PaymentAlreadyCanceledException.class, () -> canceledPayment.cancelPayment());
    }
}