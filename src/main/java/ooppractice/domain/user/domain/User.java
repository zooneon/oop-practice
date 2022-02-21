package ooppractice.domain.user.domain;

import lombok.Getter;
import ooppractice.domain.order.domain.Order;
import ooppractice.global.common.repository.Entity;

import java.util.List;

@Getter
public class User extends Entity {

    private Long id;
    private String username;
    private String password;
    private UserGrade userGrade;
    private int depositedMoney;
    private List<Order> orderList;

}
