package ooppractice.domain.user.domain;

import lombok.*;
import ooppractice.domain.order.domain.Order;
import ooppractice.global.common.repository.Entity;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends Entity {

    private Long id;
    private String username;
    private String password;
    private UserGrade userGrade;
    private int depositedMoney;
    private List<Order> orderList;

    @Builder
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userGrade = UserGrade.SILVER;
        this.depositedMoney = 0;
        this.orderList = new ArrayList<>();
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public void deposit(int amount) {
        this.depositedMoney += amount;
    }
}
