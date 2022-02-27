package ooppractice.domain.payment.repository;

import ooppractice.domain.payment.domain.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {

    private PaymentRepository paymentRepository = new PaymentRepository();

    @AfterEach
    void tearDown() {
        paymentRepository.deleteAll();
    }

    @Test
    void save() {
        //given
        Payment payment = Payment.builder().build();
        //when
        paymentRepository.save(payment);
        //then
        assertThat(payment.getId()).isEqualTo(1L);
    }
}