package ooppractice.domain.order.service;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.domain.OrderStatus;
import ooppractice.domain.order.dto.OrderResponse;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.order.repository.OrderRepository;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.orderitem.service.OrderItemService;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.service.UserService;
import ooppractice.global.util.GetLocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock private UserService userService;
    @Mock private OrderItemService orderItemService;
    @Mock private OrderRepository orderRepository;
    @Mock private GetLocalDateTime getLocalDateTime;

    @InjectMocks
    private OrderServiceImpl orderService;

    private LocalDateTime now = LocalDateTime.of(2022, 2, 25, 12, 0, 0);;
    private User user = User.builder().username("username").password("password").build();
    private Order order;
    private OrderItem orderItem = new OrderItem();
    private List<OrderItem> orderItemList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        orderItemList.add(orderItem);
        order = Order.builder().orderStatus(OrderStatus.PAYMENT_STAND_BY).orderDate(now).user(user).orderItemList(orderItemList).build();
    }

    @Test
    void makeOrder() {
        //given
        Long userId = 1L;
        String itemName = "itemName";
        int quantity = 5;
        given(getLocalDateTime.getNow()).willReturn(now);
        given(userService.getOrderUser(userId)).willReturn(user);
        given(orderItemService.makeOrderItem(itemName, quantity)).willReturn(orderItem);
        //when
        Order saved = orderService.makeOrder(userId, itemName, quantity);
        //then
        assertThat(saved.getOrderDate()).isEqualTo(now);
        assertThat(saved.getUser()).isEqualTo(user);
        assertThat(saved.getOrderStatus()).isEqualTo(OrderStatus.PAYMENT_STAND_BY);
        assertThat(saved.getOrderItemList().get(0)).isEqualTo(orderItem);
        assertThat(user.getOrderList().get(0)).isEqualTo(saved);
        assertThat(orderItem.getOrder()).isEqualTo(saved);
    }

    @Test
    void cancelOrder() {
        //given
        Long orderId = 1L;
        Long wrongId = 2L;
        given(orderRepository.findById(orderId)).willReturn(Optional.of(order));
        //when
        orderService.cancelOrder(orderId);
        //then
        assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.ORDER_CANCEL);
        assertThrows(OrderNotFoundException.class, () -> orderService.cancelOrder(wrongId));
    }

    @Test
    void getOrderById() {
        //given
        Long orderId = 1L;
        Long wrongId = 2L;
        given(orderRepository.findById(orderId)).willReturn(Optional.of(order));
        //when
        OrderResponse orderResponse = orderService.getOrderById(orderId);
        //then
        assertThat(orderResponse.getOrderStatus()).isEqualTo(OrderStatus.PAYMENT_STAND_BY);
        assertThat(orderResponse.getOrderDate()).isEqualTo(now);
        assertThat(orderResponse.getOrderItemList()).isEqualTo(orderItemList);
        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(wrongId));
    }
}