package ooppractice.domain.payment.service;

import ooppractice.domain.payment.domain.PaymentType;
import ooppractice.domain.payment.dto.PaymentListResponse;

public interface PaymentService {

    void makePayment(Long orderId, PaymentType paymentType);

    void cancelPayment(Long paymentId);

    PaymentListResponse getPaymentList(Long userId);
}
