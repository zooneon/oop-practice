package ooppractice.domain.orderitem.domain;

import ooppractice.domain.item.domain.Item;
import ooppractice.domain.order.domain.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderItemTest {

    @Test
    void createOrderItem() {
        //given
        Item item = new Item();
        int orderQuantity = 5;
        //when
        OrderItem orderItem = OrderItem.createOrderItem(item, orderQuantity);
        //then
        assertThat(orderItem.getItem()).isEqualTo(item);
        assertThat(orderItem.getOrderQuantity()).isEqualTo(orderQuantity);
    }

    @Test
    void setOrder() {
        //given
        Order order = Order.builder().build();
        OrderItem orderItem = OrderItem.builder().build();
        //when
        orderItem.setOrder(order);
        //then
        assertThat(orderItem.getOrder()).isEqualTo(order);
    }
}