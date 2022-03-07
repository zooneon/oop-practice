package ooppractice.global.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constant {

    //deposit
    public static final int LOWER_LIMIT_OF_DEPOSIT_AMOUNT = 1000;

    //view
    public static final String DOT = ".";
    public static final String BLANK = " ";
    public static final String SEMICOLON = ":";
    public static final String NEXT_LINE = "\n";
    public static final String ERROR_CODE = "에러코드";
    public static final int SB_START_INDEX = 0;
    public static final String MENU_INPUT_MESSAGE = "[실행하고자 하는 메뉴의 번호를 입력하세요]";
    public static final int OPTION_ONE = 1;
    public static final int OPTION_TWO = 2;
    public static final int OPTION_THREE = 3;
    public static final int OPTION_FOUR = 4;
    public static final int OPTION_FIVE = 5;
    public static final String QUIT = "나가기";
    public static final String WON = "원";
    public static final String BOUNDARY = "---------------------";
}
