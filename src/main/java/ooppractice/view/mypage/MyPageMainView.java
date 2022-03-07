package ooppractice.view.mypage;

import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.view.exception.SelectionException;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class MyPageMainView extends AbstractView {

    private static final String MY_INFO = "내 정보 확인하기";
    private static final String DEPOSIT = "입금하기";

    public MyPageMainView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        selectOption();
    }

    @Override
    protected void selectOption() {
        while (true) {
            showMessage();
            try {
                int userInput = scanner.nextInt();
                if (userInput == OPTION_ONE) {
                    AppConfig.getMyPageInfoView().start();
                } else if (userInput == OPTION_TWO) {
                    AppConfig.getMyPageDepositView().start();
                } else if (userInput == OPTION_THREE) {
                    break;
                } else {
                    throw new SelectionException(ErrorCode.INVALID_INPUT_VALUE);
                }
            } catch (SelectionException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            }
        }
    }

    @Override
    protected void showMessage() {
        sb.append(MENU_INPUT_MESSAGE).append(NEXT_LINE)
                .append(OPTION_ONE).append(DOT).append(MY_INFO).append(BLANK)
                .append(OPTION_TWO).append(DOT).append(DEPOSIT).append(BLANK)
                .append(OPTION_THREE).append(DOT).append(QUIT).append(BLANK);
        System.out.println(sb);
        clearSb();
    }
}
