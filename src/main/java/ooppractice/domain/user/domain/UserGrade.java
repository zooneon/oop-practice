package ooppractice.domain.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum UserGrade {
    SILVER("SILVER", value -> value + (value * 0.03), 0),
    GOLD("GOLD", value -> value + (value * 0.05), 50000),
    PLATINUM("PLATINUM", value -> value + (value * 0.1), 100000);

    private final String grade;
    private final Function<Integer, Double> expression;
    private final int standard;

    public int calculateBenefit(int amount) {
        return expression.apply(amount).intValue();
    }

    public UserGrade checkUpgrade(int amount) {
        if (amount >= GOLD.standard) {
            return GOLD;
        } else if (amount >= PLATINUM.standard) {
            return PLATINUM;
        } else {
            return SILVER;
        }
    }
}
