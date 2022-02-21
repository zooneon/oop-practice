package ooppractice.domain.orderitem.service;

import ooppractice.domain.orderitem.domain.OrderItem;

public interface OrderItemService {

    OrderItem makeOrderItem(String itemName, int quantity);
}
