package ooppractice.domain.payment.service;

import lombok.RequiredArgsConstructor;
import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.order.service.OrderService;
import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.payment.domain.PaymentType;
import ooppractice.domain.user.exception.NotEnoughMoneyException;
import ooppractice.domain.payment.exception.PaymentNotFoundException;
import ooppractice.domain.payment.repository.PaymentRepository;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.service.UserService;
import ooppractice.global.common.exception.ErrorCode;
import ooppractice.global.util.GetLocalDateTime;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderService orderService;
    private final UserService userService;
    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Payment makePayment(Long orderId, PaymentType paymentType) throws OrderNotFoundException, NotEnoughMoneyException {
        LocalDateTime paymentDate = getLocalDateTime.getNow();
        Order order = orderService.getOrderById(orderId);
        User orderUser = order.getUser();
        int afterCalculateBenefit = paymentType.calculateBenefit(order.getTotalPrice());
        orderUser.payCharge(afterCalculateBenefit);
        Payment payment = Payment.makePayment(paymentDate, paymentType, order);
        paymentRepository.save(payment);
        order.setPayment(payment);
        return payment;
    }

    @Override
    public void cancelPayment(Long paymentId) {
        Payment foundPayment = paymentRepository.findById(paymentId).orElseThrow(() -> new PaymentNotFoundException(ErrorCode.PAYMENT_NOT_FOUND));
        foundPayment.cancelPayment();
    }

    @Override
    public List<Payment> getPaymentList(Long userId) throws UserNotFoundException {
        List<Order> orderList = userService.getOrderList(userId);
        return orderList.stream().map(Order::getPayment).collect(Collectors.toList());
    }
}
