package ooppractice.domain.order.service;

import lombok.RequiredArgsConstructor;
import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.dto.OrderResponse;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.order.repository.OrderRepository;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.orderitem.exception.OutOfStockException;
import ooppractice.domain.orderitem.service.OrderItemService;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.service.UserService;
import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.util.GetLocalDateTime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final OrderItemService orderItemService;
    private final OrderRepository orderRepository;
    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Order makeOrder(Long userId, String itemName, int quantity) throws UserNotFoundException, OutOfStockException {
        LocalDateTime orderDate = getLocalDateTime.getNow();
        User user = userService.getOrderUser(userId);
        List<OrderItem> orderItemList = makeOrderItemList(itemName, quantity);
        Order order = Order.createOrder(orderDate, user, orderItemList);
        orderRepository.save(order);
        user.addOrder(order);
        orderItemList.forEach(orderItem -> orderItem.setOrder(order));
        return order;
    }

    @Override
    public void cancelOrder(Long orderId) {
        Order foundOrder = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(ErrorCode.ORDER_NOT_FOUND));
        foundOrder.cancelOrder();
    }

    @Override
    public OrderResponse getOrderById(Long orderId) {
        Order foundOrder = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(ErrorCode.ORDER_NOT_FOUND));
        return OrderResponse.of(foundOrder);
    }

    private List<OrderItem> makeOrderItemList(String itemName, int quantity) throws OutOfStockException {
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = orderItemService.makeOrderItem(itemName, quantity);
        orderItemList.add(orderItem);
        return orderItemList;
    }
}
