package ooppractice.domain.user.service;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.dto.OrderListResponse;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.dto.UserResponse;

import java.util.List;

public interface UserService {

    Long login(String username, String password);

    User getUserById(Long id);

    void makeDeposit(Long id, int amount);

    List<Order> getOrderList(Long id);

    User getOrderUser(Long id);
}
