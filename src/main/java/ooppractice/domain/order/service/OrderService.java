package ooppractice.domain.order.service;

import ooppractice.domain.order.dto.OrderResponse;

public interface OrderService {

    void makeOrder(Long userId, String itemName, int quantity);

    void cancelOrder(Long orderId);

    OrderResponse getOrderById(Long orderId);
}
