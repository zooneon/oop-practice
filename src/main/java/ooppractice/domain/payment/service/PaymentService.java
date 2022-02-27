package ooppractice.domain.payment.service;

import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.payment.domain.PaymentType;

import java.util.List;

public interface PaymentService {

    Payment makePayment(Long orderId, PaymentType paymentType);

    void cancelPayment(Long paymentId);

    List<Payment> getPaymentList(Long userId);
}
