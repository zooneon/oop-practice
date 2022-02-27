package ooppractice.domain.payment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum PaymentType {
    N_PAY("NPay", amount -> amount - (amount * 0.05)),
    KA_PAY("KaPay", amount -> amount - (amount * 0.03)),
    BM_PAY("BMPay", amount -> amount - (amount * 0.04));

    private final String name;
    private final Function<Integer, Double> expression;

    public int calculateBenefit(int amount) {
        return expression.apply(amount).intValue();
    }
}
