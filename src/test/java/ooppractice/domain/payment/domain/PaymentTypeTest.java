package ooppractice.domain.payment.domain;

import ooppractice.domain.payment.exception.PaymentTypeNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTypeTest {

    @Test
    void calculateBenefit() {
        //given
        int amount = 10000;
        //when
        int ofNPay = PaymentType.N_PAY.calculateBenefit(amount);
        int ofKaPay = PaymentType.KA_PAY.calculateBenefit(amount);
        int ofBMPay = PaymentType.BM_PAY.calculateBenefit(amount);
        //then
        assertThat(ofNPay).isEqualTo(9500);  //NPay는 5%의 할인 혜택이 있다.
        assertThat(ofKaPay).isEqualTo(9700);  //KaPay는 3%의 할인 혜택이 있다.
        assertThat(ofBMPay).isEqualTo(9600);  //BMPay는 4%의 할인 혜택이 있다.
    }

    @Test
    void getPaymentTypeByName() {
        //given
        String nameOfNPay = "NPay";
        String wrongName = "wrongName";
        //when
        PaymentType paymentTypeByName = PaymentType.getPaymentTypeByName(nameOfNPay);
        //then
        assertThat(paymentTypeByName).isEqualTo(PaymentType.N_PAY);
        assertThrows(PaymentTypeNotFoundException.class, () -> PaymentType.getPaymentTypeByName(wrongName));
    }
}