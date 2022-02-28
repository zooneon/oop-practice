package ooppractice.domain.orderitem.repository;

import ooppractice.domain.orderitem.domain.OrderItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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