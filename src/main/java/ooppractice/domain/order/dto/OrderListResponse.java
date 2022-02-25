package ooppractice.domain.order.dto;

import lombok.Builder;
import lombok.Getter;
import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.domain.OrderStatus;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.payment.domain.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderListResponse {

    private List<OrderDto> orderDtoList;

    @Builder
    public OrderListResponse(List<OrderDto> orderDtoList) {
        this.orderDtoList = orderDtoList;
    }

    public static OrderListResponse of(List<Order> orderList) {
        List<OrderDto> orderDtoList = orderList.stream().map(OrderDto::of).collect(Collectors.toList());
        return OrderListResponse.builder().orderDtoList(orderDtoList).build();
    }

    @Getter
    public static class OrderDto {
        private Long orderId;
        private OrderStatus orderStatus;
        private LocalDateTime orderDate;
        private List<OrderItem> orderItemList;
        private PaymentStatus paymentStatus;

        @Builder
        public OrderDto(Long orderId, OrderStatus orderStatus, LocalDateTime orderDate, List<OrderItem> orderItemList, PaymentStatus paymentStatus) {
            this.orderId = orderId;
            this.orderStatus = orderStatus;
            this.orderDate = orderDate;
            this.orderItemList = orderItemList;
            this.paymentStatus = paymentStatus;
        }

        public static OrderDto of(Order order) {
            return OrderDto.builder()
                    .orderId(order.getId())
                    .orderStatus(order.getOrderStatus())
                    .orderDate(order.getOrderDate())
                    .orderItemList(order.getOrderItemList())
                    .paymentStatus(order.getPayment().getPaymentStatus())
                    .build();
        }
    }
}
