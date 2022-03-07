package ooppractice.view;

import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.view.exception.SelectionException;
import ooppractice.view.mypage.MyPageMainView;
import ooppractice.view.order.OrderMainView;
import ooppractice.view.payment.PaymentMainView;
import ooppractice.view.search.SearchMainView;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class MainView extends AbstractView {

    private static final String MY_PAGE = "마이페이지";
    private static final String SEARCH = "검색";
    private static final String ORDER = "주문";
    private static final String PAYMENT = "결제";
    private static final String EXIT = "종료";

    public MainView(Scanner scanner) {
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
                    AppConfig.getMyPageMainView().start();
                } else if (userInput == OPTION_TWO) {
                    AppConfig.getSearchMainView().start();
                } else if (userInput == OPTION_THREE) {
                    AppConfig.getOrderMainView().start();
                } else if (userInput == OPTION_FOUR) {
                    AppConfig.getPaymentMainView().start();
                } else if (userInput == OPTION_FIVE) {
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
                .append(OPTION_ONE).append(DOT).append(MY_PAGE).append(BLANK)
                .append(OPTION_TWO).append(DOT).append(SEARCH).append(BLANK)
                .append(OPTION_THREE).append(DOT).append(ORDER).append(BLANK)
                .append(OPTION_FOUR).append(DOT).append(PAYMENT).append(BLANK)
                .append(OPTION_FIVE).append(DOT).append(EXIT).append(BLANK);
        System.out.println(sb);
        clearSb();
    }
}
