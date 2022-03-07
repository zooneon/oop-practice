package ooppractice.view.order;

import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.view.exception.SelectionException;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class OrderMainView extends AbstractView {

    private static final String ORDER = "주문하기";
    private static final String ORDER_INFO = "주문 정보 확인하기";
    private static final String CANCEL_ORDER = "주문 취소하기";

    public OrderMainView(Scanner scanner) {
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
                    AppConfig.getOrderView().start();
                } else if (userInput == OPTION_TWO) {
                    AppConfig.getOrderInfoView().start();
                } else if (userInput == OPTION_THREE) {
                    AppConfig.getOrderCancelView().start();
                } else if (userInput == OPTION_FOUR) {
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
                .append(OPTION_ONE).append(DOT).append(ORDER).append(BLANK)
                .append(OPTION_TWO).append(DOT).append(ORDER_INFO).append(BLANK)
                .append(OPTION_THREE).append(DOT).append(CANCEL_ORDER).append(BLANK)
                .append(OPTION_FOUR).append(DOT).append(QUIT).append(BLANK);
        System.out.println(sb);
        clearSb();
    }
}
