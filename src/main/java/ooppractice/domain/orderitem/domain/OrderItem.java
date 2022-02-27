package ooppractice.domain.orderitem.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.order.domain.Order;
import ooppractice.global.common.repository.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem extends Entity {

    private Long id;
    private Order order;
    private Item item;
    private int orderQuantity;

    protected void setId(Long id) {
        this.id = id;
    }

    @Builder
    public OrderItem(Item item, int orderQuantity) {
        this.item = item;
        this.orderQuantity = orderQuantity;
    }

    public static OrderItem createOrderItem(Item item, int orderQuantity) {
        return OrderItem.builder().item(item).orderQuantity(orderQuantity).build();
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int calculatePrice() {
        return item.getPrice() * orderQuantity;
    }
}
