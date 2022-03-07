package ooppractice.view.payment;

import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.view.exception.SelectionException;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class PaymentMainView extends AbstractView {

    private static final String PAYMENT = "결제하기";
    private static final String PAYMENT_INFO = "결제 정보 확인하기";
    private static final String CANCEL_PAYMENT = "결제 취소하기";

    public PaymentMainView(Scanner scanner) {
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
                    AppConfig.getPaymentView().start();
                } else if (userInput == OPTION_TWO) {
                    AppConfig.getPaymentInfoView().start();
                } else if (userInput == OPTION_THREE) {
                    AppConfig.getPaymentCancelView().start();
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
                .append(OPTION_ONE).append(DOT).append(PAYMENT).append(BLANK)
                .append(OPTION_TWO).append(DOT).append(PAYMENT_INFO).append(BLANK)
                .append(OPTION_THREE).append(DOT).append(CANCEL_PAYMENT).append(BLANK)
                .append(OPTION_FOUR).append(DOT).append(QUIT).append(BLANK);
        System.out.println(sb);
        clearSb();
    }
}
