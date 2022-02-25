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
        User saved = userRepository.save(User.builder().username("username").password("password").build());
        //when
        Optional<User> validUser = userRepository.findByUsername(saved.getUsername());
        Optional<User> invalidUser = userRepository.findByUsername("invalid");
        //then
        assertThat(validUser.get()).isEqualTo(saved);
        assertThat(invalidUser).isEmpty();
    }
}