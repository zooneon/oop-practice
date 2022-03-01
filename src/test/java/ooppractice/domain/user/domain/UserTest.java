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

    @Test
    void payCharge() {
        //given
        User testUser = User.builder().build();
        int testMoney = 50000;
        int exceedMoney = 100000;
        testUser.deposit(50000);
        //when
        testUser.payCharge(testMoney);
        //then
        assertThat(testUser.getDepositedMoney()).isEqualTo(0);
        assertThat(testUser.getPayedMoney()).isEqualTo(testMoney);
        assertThat(testUser.getUserGrade()).isEqualTo(UserGrade.GOLD);
        assertThrows(NotEnoughMoneyException.class, () -> testUser.payCharge(exceedMoney));
    }
}