package ooppractice.domain.order.domain;

import lombok.Getter;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.user.domain.User;
import ooppractice.global.common.repository.Entity;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order extends Entity {

    private Long id;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;
    private User user;
    private List<OrderItem> orderItemList;
    private Payment payment;

}
