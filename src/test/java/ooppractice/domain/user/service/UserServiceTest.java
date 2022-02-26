package ooppractice.domain.user.service;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.domain.OrderStatus;
import ooppractice.domain.order.dto.OrderListResponse;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.dto.UserResponse;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.exception.WrongPasswordException;
import ooppractice.domain.user.repository.UserRepository;
import ooppractice.global.common.exception.ErrorCode;
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

    private User user = User.builder().username("username").password("password").build();

    @Test
    void login() {
        //given
        String username = "username";
        String password = "password";
        String wrongUsername = "wrongUsername";
        String wrongPassword = "wrongPassword";
        given(userRepository.findByUsername(username)).willReturn(Optional.of(user));
        given(userRepository.findByUsername(wrongUsername)).willThrow(new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        //when
        //then
        assertThrows(UserNotFoundException.class, () -> userService.login(wrongUsername, password));
        assertThrows(WrongPasswordException.class, () -> userService.login(username, wrongPassword));
    }

    @Test
    void getUserById() {
        //given
        Long id = 1L;
        given(userRepository.findById(id)).willReturn(Optional.of(user));
        //when
        UserResponse userResponse = userService.getUserById(id);
        //then
        assertThat(userResponse.getUserGrade()).isEqualTo(user.getUserGrade());
        assertThat(userResponse.getDepositedMoney()).isEqualTo(user.getDepositedMoney());
    }

    @Test
    void makeDeposit() {
        //given
        Long id = 1L;
        int amount = 10000;
        int expected = 10300;  //SILVER 등급은 3%의 적립 혜택이 있다.
        given(userRepository.findById(id)).willReturn(Optional.of(user));
        //when
        userService.makeDeposit(id, amount);
        //then
        assertThat(user.getDepositedMoney()).isEqualTo(expected);
    }

    @Test
    void getOrderList() {
        //given
        Long id = 1L;
        Order order = Order.builder().orderStatus(OrderStatus.ORDER_COMPLETE).build();
        user.addOrder(order);
        given(userRepository.findById(id)).willReturn(Optional.of(user));
        //when
        OrderListResponse orderList = userService.getOrderList(id);
        //then
        assertThat(orderList.getOrderDtoList().get(0).getOrderStatus()).isEqualTo(OrderStatus.ORDER_COMPLETE);
    }

    @Test
    void getOrderUser() {
        //given
        Long id = 1L;
        given(userRepository.findById(id)).willReturn(Optional.of(user));
        //when
        User orderUser = userService.getOrderUser(id);
        //then
        assertThat(orderUser).isEqualTo(user);
    }
}