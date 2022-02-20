package ooppractice.domain.orderitem.domain;

import lombok.Getter;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.order.domain.Order;

@Getter
public class OrderItem {

    private Long id;
    private Order order;
    private Item item;
    private int orderQuantity;

}
