package ooppractice.domain.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum UserGrade {
    SILVER("SILVER", value -> value + (value * 0.03)),
    GOLD("GOLD", value -> value + (value * 0.05)),
    PLATINUM("PLATINUM", value -> value + (value * 0.1));

    private final String grade;
    private final Function<Integer, Double> expression;

    public int calculateBenefit(int amount) {
        return expression.apply(amount).intValue();
    }
}
