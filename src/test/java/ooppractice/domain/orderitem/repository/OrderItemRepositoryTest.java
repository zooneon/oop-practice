package ooppractice.domain.orderitem.repository;

import ooppractice.domain.item.domain.Item;
import ooppractice.domain.orderitem.domain.OrderItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderItemRepositoryTest {

    private OrderItemRepository orderItemRepository = new OrderItemRepository();

    @AfterEach
    void tearDown() {
        orderItemRepository.deleteAll();
    }

    @Test
    void save() {
        //given
        OrderItem orderItem = OrderItem.builder().build();
        //when
        orderItemRepository.save(orderItem);
        //then
        assertThat(orderItem.getId()).isEqualTo(1L);
    }
}