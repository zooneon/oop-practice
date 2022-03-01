package ooppractice.domain.order.domain;

import ooppractice.domain.item.domain.Item;
import ooppractice.domain.order.exception.OrderAlreadyCanceledException;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.user.domain.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        Order canceledOrder = Order.builder().orderStatus(OrderStatus.ORDER_CANCEL).build();
        //when
        order.cancelOrder();
        //then
        assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.ORDER_CANCEL);
        assertThrows(OrderAlreadyCanceledException.class, () -> canceledOrder.cancelOrder());
    }

    @Test
    void getTotalPrice() {
        //given
        int itemPrice = 10000;
        int orderQuantity = 5;
        Item item = Item.builder().price(itemPrice).build();
        OrderItem firstItem = OrderItem.builder().item(item).orderQuantity(orderQuantity).build();
        OrderItem secondItem = OrderItem.builder().item(item).orderQuantity(orderQuantity).build();
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(firstItem);
        orderItemList.add(secondItem);
        Order order = Order.builder().orderItemList(orderItemList).build();
        //when
        int totalPrice = order.getTotalPrice();
        //then
        assertThat(totalPrice).isEqualTo(firstItem.calculatePrice() + secondItem.calculatePrice());
    }

    @Test
    void setPayment() {
        //given
        Order order = Order.builder().build();
        Payment payment = Payment.builder().build();
        //when
        order.setPayment(payment);
        //then
        assertThat(order.getPayment()).isEqualTo(payment);
    }
}
