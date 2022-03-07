package ooppractice.view;

import ooppractice.domain.order.exception.OrderAlreadyCanceledException;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.order.exception.PaymentNotCanceledException;
import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.payment.exception.PaymentAlreadyCanceledException;
import ooppractice.domain.payment.exception.PaymentNotFoundException;
import ooppractice.domain.payment.service.PaymentService;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.global.util.UserIdStorage;
import ooppractice.view.exception.SelectionException;

import java.util.List;
import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class PaymentInfoView extends AbstractView {

    private static final String PAYMENT_CANCEL_INPUT_MESSAGE = "[취소하고자 하는 결제 번호를 입력하세요]";
    private static final String CANCEL_COMPLETE = "[취소 완료]";
    private static final String PAYMENT_INFO = "결제 정보";
    private static final String CANCEL_PAYMENT = "결제 취소";
    private static final String PAYMENT_NUMBER = "결제 번호";
    private static final String PAYMENT_STATUS = "결제 상태";
    private static final String PAYMENT_DATE = "결제 일자";
    private static final String ORDER_NUMBER = "주문 번호";
    private static final String PAYMENT_PRICE = "결제 금액";

    private PaymentService paymentService = AppConfig.getPaymentService();

    public PaymentInfoView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        selectOption();
    }

    private void selectOption() {
        while (true) {
            showMessage();
            try {
                int userInput = scanner.nextInt();
                if (userInput == OPTION_ONE) {
                    showPaymentInfo();
                } else if (userInput == OPTION_TWO) {
                    cancelPayment();
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

    private void cancelPayment() {
        while (true) {
            System.out.println(PAYMENT_CANCEL_INPUT_MESSAGE);
            try {
                Long paymentId = scanner.nextLong();
                paymentService.cancelPayment(paymentId);
                System.out.println(CANCEL_COMPLETE);
                break;
            } catch (PaymentAlreadyCanceledException | OrderAlreadyCanceledException | PaymentNotFoundException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            }
        }
    }


    @Override
    protected void showMessage() {
        sb.append(MENU_INPUT_MESSAGE).append(NEXT_LINE)
                .append(OPTION_ONE).append(DOT).append(PAYMENT_INFO).append(BLANK)
                .append(OPTION_TWO).append(DOT).append(CANCEL_PAYMENT).append(BLANK)
                .append(OPTION_THREE).append(DOT).append(QUIT).append(BLANK);
        System.out.println(sb);
        clearSb();
    }

    private void showPaymentInfo() {
        Long userId = UserIdStorage.getId();
        printPaymentInfo(userId);
    }

    private void printPaymentInfo(Long userId) {
        try {
            List<Payment> paymentList = paymentService.getPaymentList(userId);
            paymentList.forEach(payment -> {
                sb.append(PAYMENT_NUMBER).append(SEMICOLON).append(BLANK).append(payment.getId()).append(NEXT_LINE)
                        .append(PAYMENT_STATUS).append(SEMICOLON).append(BLANK).append(payment.getPaymentStatus().getMessage()).append(NEXT_LINE)
                        .append(PAYMENT_DATE).append(SEMICOLON).append(BLANK).append(payment.getPaymentDate()).append(NEXT_LINE)
                        .append(ORDER_NUMBER).append(SEMICOLON).append(BLANK).append(payment.getOrder().getId()).append(NEXT_LINE)
                        .append(PAYMENT_PRICE).append(SEMICOLON).append(BLANK).append(payment.getOrder().getTotalPrice());
                System.out.println(sb);
                clearSb();
            });
        } catch (UserNotFoundException | PaymentNotFoundException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
            return;
        }
    }
}
