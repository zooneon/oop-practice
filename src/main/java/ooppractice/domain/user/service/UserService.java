package ooppractice.domain.user.service;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.user.domain.User;

import java.util.List;

public interface UserService {

    Long login(String username, String password);

    User getUserById(Long id);

    void makeDeposit(Long id, int amount);

    List<Order> getOrderList(Long id);
}
