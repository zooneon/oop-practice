package ooppractice.domain.user.domain;

import ooppractice.domain.order.domain.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void deposit() {
        //given
        User user = User.builder().username("username").password("password").build();
        //when
        user.deposit(1000);
        //then
        assertThat(user.getDepositedMoney()).isEqualTo(1000);
    }

    @Test
    void addOrder() {
        //given
        User user = User.builder().username("username").password("password").build();
        Order order = Order.builder().orderDate(LocalDateTime.now()).user(user).orderItemList(new ArrayList<>()).build();
        //when
        user.addOrder(order);
        //then
        assertThat(user.getOrderList().get(0)).isEqualTo(order);
    }
}