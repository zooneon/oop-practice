package ooppractice.domain.user.domain;

import lombok.Getter;
import ooppractice.domain.order.domain.Order;

import java.util.List;

@Getter
public class User {

    private Long id;
    private String userId;
    private String password;
    private UserType userType;
    private int depositedMoney;
    private List<Order> orderList;

}
