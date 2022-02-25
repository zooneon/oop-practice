package ooppractice.domain.order.repository;

import ooppractice.domain.order.domain.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderRepositoryTest {

    private OrderRepository orderRepository = new OrderRepository();

    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
    }

    @Test
    void save() {
        //given
        Order order = Order.builder().build();
        //when
        orderRepository.save(order);
        //then
        assertThat(order.getId()).isEqualTo(1L);
    }
}