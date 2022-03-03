package ooppractice.domain.payment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ooppractice.global.util.Constant;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum PaymentType {
    N_PAY("NPay", amount -> amount - (amount * Constant.N_PAY_BENEFIT)),
    KA_PAY("KaPay", amount -> amount - (amount * Constant.KA_PAY_BENEFIT)),
    BM_PAY("BMPay", amount -> amount - (amount * Constant.BM_PAY_BENEFIT));

    private final String name;
    private final Function<Integer, Double> expression;

    public int calculateBenefit(int amount) {
        return expression.apply(amount).intValue();
    }
}
