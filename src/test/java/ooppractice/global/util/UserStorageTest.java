package ooppractice.global.util;

import ooppractice.domain.user.domain.User;
import ooppractice.global.util.UserStorage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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