package ooppractice.domain.order.service;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.domain.OrderStatus;
import ooppractice.domain.order.repository.OrderRepository;
import ooppractice.domain.orderitem.service.OrderItemService;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.service.UserService;
import ooppractice.global.util.GetLocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock private UserService userService;
    @Mock private OrderItemService orderItemService;
    @Mock private OrderRepository orderRepository;
    @Mock private GetLocalDateTime getLocalDateTime;

    @InjectMocks
    private OrderServiceImpl orderService;

    private User user = User.builder().username("username").password("password").build();
    private Order order = Order.builder().orderStatus(OrderStatus.PAYMENT_STAND_BY).user(user).build();

    @Test
    void makeOrder() {
    }

    @Test
    void cancelOrder() {
        //given
        Long orderId = 1L;
        given(orderRepository.findById(orderId)).willReturn(Optional.of(order));
        //when
        orderService.cancelOrder(orderId);
        //then
        assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.ORDER_CANCEL);
    }

    @Test
    void getOrderById() {
    }
}