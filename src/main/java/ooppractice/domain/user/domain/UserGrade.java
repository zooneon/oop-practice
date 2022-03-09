package ooppractice.domain.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum UserGrade {
    SILVER("SILVER", 0.03, amount -> amount + (amount * 0.03), 0),
    GOLD("GOLD", 0.05, amount -> amount + (amount * 0.05), 50000),
    PLATINUM("PLATINUM", 0.1, amount -> amount + (amount * 0.1), 100000);

    private final String grade;
    private final Double benefitRatio;
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
