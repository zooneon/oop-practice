package ooppractice.domain.user.domain;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.user.exception.NotEnoughMoneyException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void deposit() {
        //given
        int amount = 1000;
        User user = User.builder().build();
        //when
        user.deposit(amount);
        //then
        assertThat(user.getDepositedMoney()).isEqualTo(amount);
    }

    @Test
    void addOrder() {
        //given
        User user = User.builder().build();
        Order order = Order.builder().build();
        //when
        user.addOrder(order);
        //then
        assertThat(user.getOrderList().get(0)).isEqualTo(order);
    }

    @Test
    void payCharge() {
        //given
        User testUser = User.builder().build();
        int amount = 50000;
        int testMoney = 50000;
        int exceedMoney = 100000;
        testUser.deposit(amount);
        //when
        testUser.payCharge(testMoney);
        //then
        assertThat(testUser.getDepositedMoney()).isEqualTo(amount - testMoney);
        assertThat(testUser.getPayedMoney()).isEqualTo(testMoney);
        assertThat(testUser.getUserGrade()).isEqualTo(UserGrade.GOLD);
        assertThrows(NotEnoughMoneyException.class, () -> testUser.payCharge(exceedMoney));
    }
}