package ooppractice.domain.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ooppractice.global.util.Constant;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum UserGrade {
    SILVER("SILVER", amount -> amount + (amount * Constant.SILVER_BENEFIT), Constant.SILVER_STANDARD),
    GOLD("GOLD", amount -> amount + (amount * Constant.GOLD_BENEFIT), Constant.GOLD_STANDARD),
    PLATINUM("PLATINUM", amount -> amount + (amount * Constant.PLATINUM_BENEFIT), Constant.PLATINUM_STANDARD);

    private final String grade;
    private final Function<Integer, Double> expression;
    private final int standard;

    public int calculateBenefit(int amount) {
        return expression.apply(amount).intValue();
    }

    public UserGrade checkUpgrade(int amount) {
        if (amount >= PLATINUM.standard) {
            return PLATINUM;
        } else if (amount >= GOLD.standard) {
            return GOLD;
        } else {
            return SILVER;
        }
    }
}
