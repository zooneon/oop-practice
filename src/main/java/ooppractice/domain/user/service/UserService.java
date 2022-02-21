package ooppractice.domain.user.service;

import ooppractice.domain.order.dto.OrderListResponse;
import ooppractice.domain.user.dto.UserResponse;

public interface UserService {

    void login(String username, String password);

    UserResponse getUser(Long id);

    void makeDeposit(Long id, int amount);

    OrderListResponse getOrderList(Long id);
}
