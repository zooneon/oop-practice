package ooppractice.domain.order.domain;

import lombok.Getter;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.user.domain.User;

import java.util.List;

@Getter
public class Order {

    private Long id;
    private OrderStatus orderStatus;
    private User user;
    private List<OrderItem> orderItemList;
    private Payment payment;

}
