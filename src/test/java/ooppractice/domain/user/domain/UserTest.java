package ooppractice.domain.user.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}