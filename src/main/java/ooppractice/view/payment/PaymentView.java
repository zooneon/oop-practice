package ooppractice.view.payment;

import ooppractice.domain.order.exception.OrderAlreadyCanceledException;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.payment.domain.PaymentType;
import ooppractice.domain.payment.exception.PaymentTypeNotFoundException;
import ooppractice.domain.payment.service.PaymentService;
import ooppractice.domain.user.exception.NotEnoughMoneyException;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.exception.ErrorResponse;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class PaymentView extends AbstractView {

    private static final String PAYMENT_INPUT_MESSAGE = "[결제할 주문 번호와 결제 방법을 순서대로 입력하세요]";
    private static final String PAYMENT_SUCCESS_MESSAGE = "[결제 완료]";
    private static final String PAYMENT_TYPE = "결제 방법";

    private final PaymentService paymentService;

    public PaymentView(Scanner scanner, PaymentService paymentService) {
        super(scanner);
        this.paymentService = paymentService;
    }

    @Override
    public void start() {
        pay();
    }

    @Override
    protected void selectOption() {
    }

    private void pay() {
        showMessage();
        try {
            Long orderId = scanner.nextLong();
            String paymentTypeName = scanner.next();
            paymentService.makePayment(orderId, PaymentType.getPaymentTypeByName(paymentTypeName));
            System.out.println(PAYMENT_SUCCESS_MESSAGE);
        } catch (PaymentTypeNotFoundException | OrderNotFoundException | OrderAlreadyCanceledException | NotEnoughMoneyException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        }
    }

    @Override
    protected void showMessage() {
        sb.append(PAYMENT_INPUT_MESSAGE).append(NEXT_LINE)
                .append(PAYMENT_TYPE).append(SEMICOLON).append(BLANK)
                .append(PaymentType.N_PAY.getName()).append(BLANK)
                .append(PaymentType.KA_PAY.getName()).append(BLANK)
                .append(PaymentType.BM_PAY.getName()).append(BLANK);
        System.out.println(sb);
        clearSb();
    }
}
