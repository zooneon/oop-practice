package ooppractice.domain.payment.domain;

import lombok.Getter;
import ooppractice.domain.order.domain.Order;
import ooppractice.global.common.repository.Entity;

@Getter
public class Payment extends Entity {

    private Long id;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private Order order;

}
