package ooppractice.domain.user.domain;

import lombok.Getter;
import ooppractice.domain.order.domain.Order;

import java.util.List;

@Getter
public class User {

    private Long id;
    private String username;
    private String password;
    private UserGrade userGrade;
    private int depositedMoney;
    private List<Order> orderList;

}
