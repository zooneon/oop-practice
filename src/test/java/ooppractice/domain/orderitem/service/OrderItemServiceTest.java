package ooppractice.domain.orderitem.service;

import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.service.ItemService;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.orderitem.repository.OrderItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OrderItemServiceTest {

    @Mock
    private ItemService itemService;
    @Mock
    private OrderItemRepository orderItemRepository;
    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    private Item item = new Item();

    //TODO: 재고 부족 예외 테스트
    @Test
    void makeOrderItem() {
        //given
        String itemName = "itemName";
        int quantity = 0;
        given(itemService.getItemByName(itemName)).willReturn(item);
        //when
        OrderItem orderItem = orderItemService.makeOrderItem(itemName, quantity);
        //then
        assertThat(orderItem.getItem()).isEqualTo(item);
        assertThat(orderItem.getOrderQuantity()).isEqualTo(quantity);
    }
}