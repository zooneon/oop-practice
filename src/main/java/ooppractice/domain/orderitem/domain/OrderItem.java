package ooppractice.domain.orderitem.domain;

import lombok.Getter;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.order.domain.Order;
import ooppractice.global.common.repository.Entity;

@Getter
public class OrderItem extends Entity {

    private Long id;
    private Order order;
    private Item item;
    private int orderQuantity;

}
