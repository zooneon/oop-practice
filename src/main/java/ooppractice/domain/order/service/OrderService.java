package ooppractice.domain.order.service;

import ooppractice.domain.order.domain.Order;

public interface OrderService {

    Order makeOrder(Long userId, String itemName, int quantity);

    void cancelOrder(Long orderId);

    Order getOrderById(Long orderId);
}
