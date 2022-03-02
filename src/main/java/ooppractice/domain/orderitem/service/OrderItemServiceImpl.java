package ooppractice.domain.orderitem.service;

import lombok.RequiredArgsConstructor;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.domain.SalesStatus;
import ooppractice.domain.item.exception.ItemNotFoundException;
import ooppractice.domain.item.service.ItemService;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.orderitem.exception.OutOfStockException;
import ooppractice.domain.orderitem.exception.SoldOutException;
import ooppractice.domain.orderitem.repository.OrderItemRepository;
import ooppractice.global.exception.ErrorCode;

@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final ItemService itemService;
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem makeOrderItem(String itemName, int quantity) throws ItemNotFoundException {
        Item item = itemService.getItemByItemName(itemName);
        if (item.getSalesStatus() == SalesStatus.SOLD_OUT) {
            throw new SoldOutException(ErrorCode.SOLD_OUT);
        }
        if (item.getStockQuantity() < quantity) {
            throw new OutOfStockException(ErrorCode.OUT_OF_STOCK);
        }
        item.reduceStockQuantity(quantity);
        OrderItem orderItem = OrderItem.createOrderItem(item, quantity);
        orderItemRepository.save(orderItem);
        return orderItem;
    }
}
