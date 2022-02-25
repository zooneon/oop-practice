package ooppractice.domain.user.service;

import ooppractice.domain.order.dto.OrderListResponse;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.dto.UserResponse;

public interface UserService {

    Long login(String username, String password);

    UserResponse getUserBy(Long id);

    void makeDeposit(Long id, int amount);

    OrderListResponse getOrderList(Long id);

    User getOrderUser(Long id);
}
