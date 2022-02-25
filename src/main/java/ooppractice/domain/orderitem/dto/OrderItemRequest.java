package ooppractice.domain.orderitem.dto;

import lombok.Getter;

@Getter
public class OrderItemRequest {

    private String itemName;
    private int quantity;
}
