package ooppractice.domain.user.repository;

import ooppractice.domain.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest {

    private UserRepository userRepository = new UserRepository();

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void findByUsername () {
        //given
        String username = "username";
        String wrongName = "wrongName";
        User saved = userRepository.save(User.builder().username(username).build());
        //when
        Optional<User> validUser = userRepository.findByUsername(username);
        Optional<User> invalidUser = userRepository.findByUsername(wrongName);
        //then
        assertThat(validUser.get()).isEqualTo(saved);
        assertThat(invalidUser).isEmpty();
    }
}