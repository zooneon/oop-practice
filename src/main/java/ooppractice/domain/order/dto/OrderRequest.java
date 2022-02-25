package ooppractice.domain.order.dto;

import lombok.Getter;
import ooppractice.domain.orderitem.dto.OrderItemRequest;

import java.util.List;

@Getter
public class OrderRequest {

    private Long userId;
    private List<OrderItemRequest> orderItemRequestList;
}
