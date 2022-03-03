package ooppractice.global.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constant {

    //user grade
    public static final double SILVER_BENEFIT = 0.03;
    public static final double GOLD_BENEFIT = 0.05;
    public static final double PLATINUM_BENEFIT = 0.1;
    public static final int SILVER_STANDARD = 0;
    public static final int GOLD_STANDARD = 50000;
    public static final int PLATINUM_STANDARD = 100000;

    //payment type
    public static final double N_PAY_BENEFIT = 0.05;
    public static final double BM_PAY_BENEFIT = 0.04;
    public static final double KA_PAY_BENEFIT = 0.03;

    //view
    public static final String BLANK = " ";
    public static final String SEMICOLON = ":";
    public static final String NEXT_LINE = "\n";
    public static final String ERROR_CODE = "에러코드";
}
