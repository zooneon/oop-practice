package ooppractice.domain.user.service;

import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.exception.InvalidAmountException;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.exception.WrongPasswordException;
import ooppractice.domain.user.repository.UserRepository;
import ooppractice.global.exception.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    String username = "username";
    String password = "password";
    private User user = User.builder().username(username).password(password).build();

    @Test
    void login() {
        //given
        String wrongUsername = "wrongUsername";
        String wrongPassword = "wrongPassword";
        given(userRepository.findByUsername(username)).willReturn(Optional.of(user));
        given(userRepository.findByUsername(wrongUsername)).willThrow(new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        //when
        User loginUser = userService.login(username, password);
        //then
        assertThat(loginUser).isEqualTo(user);
        assertThrows(UserNotFoundException.class, () -> userService.login(wrongUsername, password));
        assertThrows(WrongPasswordException.class, () -> userService.login(username, wrongPassword));
    }

    @Test
    void getUserById() {
        //given
        Long id = 1L;
        given(userRepository.findById(id)).willReturn(Optional.of(user));
        //when
        User user = userService.getUserById(id);
        //then
        assertThat(user.getUserGrade()).isEqualTo(user.getUserGrade());
        assertThat(user.getDepositedMoney()).isEqualTo(user.getDepositedMoney());
    }

    @Test
    void makeDeposit() {
        //given
        Long id = 1L;
        int amount = 10000;
        int expected = 10300;  //SILVER ????????? 3%??? ?????? ????????? ??????.
        int invalidAmount = 0;
        given(userRepository.findById(id)).willReturn(Optional.of(user));
        //when
        userService.makeDeposit(id, amount);
        //then
        assertThat(user.getDepositedMoney()).isEqualTo(expected);
        assertThrows(InvalidAmountException.class, () -> userService.makeDeposit(id, invalidAmount));
    }
}