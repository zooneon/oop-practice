package ooppractice.domain.order.dto;

import lombok.Builder;
import lombok.Getter;
import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.domain.OrderStatus;
import ooppractice.domain.orderitem.domain.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderResponse {

    private OrderStatus orderStatus;
    private LocalDateTime orderDate;
    private List<OrderItem> orderItemList;

    @Builder
    public OrderResponse(OrderStatus orderStatus, LocalDateTime orderDate, List<OrderItem> orderItemList) {
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.orderItemList = orderItemList;
    }

    public static OrderResponse of(Order order) {
        return OrderResponse.builder()
                .orderStatus(order.getOrderStatus())
                .orderDate(order.getOrderDate())
                .orderItemList(order.getOrderItemList())
                .build();
    }
}
