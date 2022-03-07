package ooppractice.view.payment;

import ooppractice.domain.payment.domain.Payment;
import ooppractice.domain.payment.exception.PaymentNotFoundException;
import ooppractice.domain.payment.service.PaymentService;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.global.util.UserIdStorage;

import java.util.List;
import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class PaymentInfoView extends AbstractView {

    private static final String PAYMENT_NUMBER = "결제 번호";
    private static final String PAYMENT_STATUS = "결제 상태";
    private static final String PAYMENT_DATE = "결제 일자";
    private static final String ORDER_NUMBER = "주문 번호";
    private static final String PAYMENT_PRICE = "결제 금액";

    private final PaymentService paymentService;

    public PaymentInfoView(Scanner scanner, PaymentService paymentService) {
        super(scanner);
        this.paymentService = paymentService;
    }

    @Override
    public void start() {
        showMessage();
    }

    @Override
    protected void selectOption() {
    }

    @Override
    protected void showMessage() {
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
                        .append(PAYMENT_PRICE).append(SEMICOLON).append(BLANK).append(payment.getOrder().getTotalPrice()).append(NEXT_LINE)
                        .append(BOUNDARY).append(NEXT_LINE);
            });
            System.out.println(sb);
            clearSb();
        } catch (PaymentNotFoundException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(ErrorCode.LOGIN_USER_NOT_FOUND);
        }
    }
}
