package ooppractice.domain.user.service;

import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.exception.WrongPasswordException;
import ooppractice.domain.user.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserServiceTest {

    private UserRepository userRepository = new UserRepository();
    private UserService userService = new UserServiceImpl(userRepository);
    private User user = User.builder().username("username").password("password").build();

    @BeforeEach
    void setUp() {
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void login() {
        //given
        String username = "username";
        String password = "password";
        String wrongUsername = "wrongUsername";
        String wrongPassword = "wrongPassword";
        //when
        Long userId = userService.login(username, password);
        //then
        assertThat(userId).isEqualTo(1L);
        assertThrows(UserNotFoundException.class, () -> userService.login(wrongUsername, password));
        assertThrows(WrongPasswordException.class, () -> userService.login(username, wrongPassword));
    }

    @Test
    void getUser() {
        //given
        Long id = 1L;
        //when
        User foundUser = userService.getUser(id);
        //then
        assertThat(foundUser.getUserGrade()).isEqualTo(user.getUserGrade());
        assertThat(foundUser.getDepositedMoney()).isEqualTo(user.getDepositedMoney());
    }

    @Test
    void makeDeposit() {
        //given
        Long id = 1L;
        int amount = 10000;
        int expected = 10300;  //SILVER 등급은 3%의 적립 혜택이 있다.
        //when
        userService.makeDeposit(id, amount);
        //then
        assertThat(user.getDepositedMoney()).isEqualTo(expected);
    }

    //TODO: 주문 도메인 작성 후 테스트 추가
    @Test
    void getOrderList() {
        //given

        //when

        //then

    }
}