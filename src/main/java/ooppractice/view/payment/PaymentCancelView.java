package ooppractice.view.payment;

import ooppractice.domain.order.exception.OrderAlreadyCanceledException;
import ooppractice.domain.payment.exception.PaymentAlreadyCanceledException;
import ooppractice.domain.payment.exception.PaymentNotFoundException;
import ooppractice.domain.payment.service.PaymentService;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.exception.ErrorResponse;

import java.util.Scanner;

public class PaymentCancelView extends AbstractView {

    private static final String PAYMENT_CANCEL_INPUT_MESSAGE = "[취소할 결제의 번호를 입력해주세요]";
    private static final String PAYMENT_CANCEL_SUCCESS_MESSAGE = "[결제 취소 완료]";

    private final PaymentService paymentService;

    public PaymentCancelView(Scanner scanner, PaymentService paymentService) {
        super(scanner);
        this.paymentService = paymentService;
    }

    @Override
    public void start() {
        cancel();
    }

    private void cancel() {
        showMessage();
        try {
            Long paymentId = scanner.nextLong();
            paymentService.cancelPayment(paymentId);
            System.out.println(PAYMENT_CANCEL_SUCCESS_MESSAGE);
        } catch (PaymentNotFoundException | OrderAlreadyCanceledException | PaymentAlreadyCanceledException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        }
    }

    @Override
    protected void selectOption() {
    }

    @Override
    protected void showMessage() {
        System.out.println(PAYMENT_CANCEL_INPUT_MESSAGE);
    }
}
