package ooppractice.domain.payment.service;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.service.OrderService;
import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.payment.domain.PaymentStatus;
import ooppractice.domain.payment.domain.PaymentType;
import ooppractice.domain.payment.repository.PaymentRepository;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.domain.UserGrade;
import ooppractice.global.util.GetLocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock private PaymentRepository paymentRepository;
    @Mock private OrderService orderService;
    @Mock private GetLocalDateTime getLocalDateTime;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private LocalDateTime now = LocalDateTime.of(2022, 2, 27, 12, 0, 0);
    private User user = User.builder().build();
    private Order order = Order.builder().user(user).build();

    @BeforeEach
    void setUp() {
        user.addOrder(order);
    }

    @Test
    void makePayment() {
        //given
        Order mockOrder = mock(Order.class);
        Long id = 1L;
        int totalPrice = 60000;
        int depositedMoney = 60000;
        PaymentType paymentType = PaymentType.N_PAY;
        int afterCalculateBenefit = paymentType.calculateBenefit(totalPrice);
        given(getLocalDateTime.getNow()).willReturn(now);
        given(orderService.getOrderById(id)).willReturn(mockOrder);
        given(mockOrder.getUser()).willReturn(user);
        given(mockOrder.getTotalPrice()).willReturn(totalPrice);
        user.deposit(depositedMoney);
        //when
        Payment payment = paymentService.makePayment(id, paymentType);
        //then
        assertThat(payment.getPaymentDate()).isEqualTo(now);
        assertThat(payment.getPaymentType()).isEqualTo(PaymentType.N_PAY);
        assertThat(payment.getPaymentStatus()).isEqualTo(PaymentStatus.COMPLETE);
        assertThat(user.getDepositedMoney()).isEqualTo(depositedMoney - afterCalculateBenefit);
        assertThat(user.getUserGrade()).isEqualTo(UserGrade.GOLD);
    }

    @Test
    void cancelPayment() {
        //given
        Long id = 1L;
        Payment payment = Payment.builder().paymentStatus(PaymentStatus.COMPLETE).build();
        given(paymentRepository.findById(id)).willReturn(Optional.of(payment));
        //when
        paymentService.cancelPayment(id);
        //then
        assertThat(payment.getPaymentStatus()).isEqualTo(PaymentStatus.CANCEL);
    }

    @Test
    void getPaymentList() {
        //given
        Long id = 1L;
        Payment payment = Payment.builder().order(order).build();
        order.setPayment(payment);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        given(orderService.getOrderList(id)).willReturn(orderList);
        //when
        List<Payment> paymentList = paymentService.getPaymentList(id);
        //then
        assertThat(paymentList.size()).isEqualTo(1);
        assertThat(paymentList.get(0)).isEqualTo(payment);
    }
}