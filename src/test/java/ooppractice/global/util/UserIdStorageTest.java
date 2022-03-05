package ooppractice.global.util;

import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserIdStorageTest {

    private UserRepository userRepository = new UserRepository();

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void get() {
        //given
        User user = User.builder().build();
        userRepository.save(user);
        UserIdStorage.saveId(user.getId());
        //when
        Long userId = UserIdStorage.getId();
        //then
        assertThat(userId).isEqualTo(user.getId());
    }
}