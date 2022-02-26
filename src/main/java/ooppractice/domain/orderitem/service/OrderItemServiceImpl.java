package ooppractice.domain.orderitem.service;

import lombok.RequiredArgsConstructor;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.service.ItemService;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.orderitem.exception.OutOfStockException;
import ooppractice.domain.orderitem.repository.OrderItemRepository;
import ooppractice.global.common.exception.ErrorCode;

@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final ItemService itemService;
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem makeOrderItem(String itemName, int quantity) {
        Item item = itemService.getItemByName(itemName);
        if (item.getStockQuantity() < quantity) {
            throw new OutOfStockException(ErrorCode.OUT_OF_STOCK);
        }
        OrderItem orderItem = OrderItem.createOrderItem(item, quantity);
        orderItemRepository.save(orderItem);
        return orderItem;
    }
}
