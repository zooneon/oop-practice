package ooppractice.domain.payment.domain;

import ooppractice.domain.order.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void makePayment() {
        //given
        LocalDateTime paymentDate = LocalDateTime.of(2022, 2, 27, 0, 0, 0);
        PaymentType paymentType = PaymentType.BM_PAY;
        Order order = Order.builder().build();
        //when
        Payment payment = Payment.makePayment(paymentDate, paymentType, order);
        //then
        assertThat(payment.getPaymentDate()).isEqualTo(paymentDate);
        assertThat(payment.getPaymentStatus()).isEqualTo(PaymentStatus.COMPLETE);
        assertThat(payment.getPaymentType()).isEqualTo(paymentType);
        assertThat(payment.getOrder()).isEqualTo(order);
    }

    @Test
    void cancelPayment() {
        //given
        Payment payment = Payment.builder().paymentStatus(PaymentStatus.COMPLETE).build();
        //when
        payment.cancelPayment();
        //then
        assertThat(payment.getPaymentStatus()).isEqualTo(PaymentStatus.CANCEL);
    }
}