package ooppractice.domain.order.domain;

import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.user.domain.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void createOrder() {
        //given
        LocalDateTime orderDate = LocalDateTime.of(2022, 2, 25, 12, 0, 0);
        User user = User.builder().build();
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(OrderItem.builder().build());
        //when
        Order order = Order.createOrder(orderDate, user, orderItemList);
        //then
        assertThat(order.getUser()).isEqualTo(user);
        assertThat(order.getOrderDate()).isEqualTo(orderDate);
        assertThat(order.getOrderItemList()).isEqualTo(orderItemList);
        assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.PAYMENT_STAND_BY);
        assertThat(order.getPayment()).isNull();
    }

    @Test
    void cancelOrder() {
        //given
        Order order = Order.builder().orderStatus(OrderStatus.PAYMENT_STAND_BY).build();
        //when
        order.cancelOrder();
        //then
        assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.ORDER_CANCEL);
    }
}
