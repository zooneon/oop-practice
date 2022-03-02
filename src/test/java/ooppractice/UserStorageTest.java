package ooppractice;

import ooppractice.domain.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserStorageTest {

    @Test
    void get() {
        //given
        User user = User.builder().build();
        UserStorage.save(user);
        //when
        User getUser = UserStorage.get();
        //then
        assertThat(getUser).isEqualTo(user);
    }
}