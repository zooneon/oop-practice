package ooppractice.domain.orderitem.service;

import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.service.ItemService;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.orderitem.exception.OutOfStockException;
import ooppractice.domain.orderitem.exception.SoldOutException;
import ooppractice.domain.orderitem.repository.OrderItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OrderItemServiceTest {

    @Mock
    private ItemService itemService;
    @Mock
    private OrderItemRepository orderItemRepository;
    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    int stockQuantity = 10;
    private Item item = Item.builder().stockQuantity(stockQuantity).build();

    @Test
    void makeOrderItem() {
        //given
        String itemName = "itemName";
        int properQuantity = 5;
        int overQuantity = 15;
        int remainQuantity = item.getStockQuantity() - properQuantity;
        given(itemService.getItemByItemName(itemName)).willReturn(item);
        //when
        OrderItem orderItem = orderItemService.makeOrderItem(itemName, properQuantity);
        //then
        assertThat(orderItem.getItem()).isEqualTo(item);
        assertThat(orderItem.getOrderQuantity()).isEqualTo(properQuantity);
        assertThat(item.getStockQuantity()).isEqualTo(remainQuantity);
        assertThrows(OutOfStockException.class, () -> orderItemService.makeOrderItem(itemName, overQuantity));
        item.reduceStockQuantity(remainQuantity);
        assertThrows(SoldOutException.class, () -> orderItemService.makeOrderItem(itemName, properQuantity));
    }
}