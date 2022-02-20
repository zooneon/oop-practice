package ooppractice.domain.payment.domain;

import lombok.Getter;
import ooppractice.domain.order.domain.Order;

@Getter
public class Payment {

    private Long id;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private Order order;

}
