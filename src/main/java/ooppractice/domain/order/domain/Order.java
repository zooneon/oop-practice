package ooppractice.domain.order.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.user.domain.User;
import ooppractice.global.common.repository.Entity;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends Entity {

    private Long id;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;
    private User user;
    private List<OrderItem> orderItemList;
    private Payment payment;

    protected void setId(Long id) {
        this.id = id;
    }

    @Builder
    public Order(OrderStatus orderStatus, LocalDateTime orderDate, User user, List<OrderItem> orderItemList) {
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.user = user;
        this.orderItemList = orderItemList;
    }

    public static Order createOrder(LocalDateTime orderDate, User user, List<OrderItem> orderItemList) {
        return Order.builder()
                .orderStatus(OrderStatus.PAYMENT_STAND_BY)
                .orderDate(orderDate)
                .user(user)
                .orderItemList(orderItemList)
                .build();
    }

    public void cancelOrder() {
        this.orderStatus = OrderStatus.ORDER_CANCEL;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        orderItemList.stream().map(orderItem -> totalPrice + orderItem.calculatePrice());
        return totalPrice;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
