package ooppractice.view;

import ooppractice.domain.order.exception.OrderAlreadyCanceledException;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.payment.domain.PaymentType;
import ooppractice.domain.payment.exception.PaymentTypeNotFoundException;
import ooppractice.domain.payment.service.PaymentService;
import ooppractice.domain.user.exception.NotEnoughMoneyException;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorResponse;

import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class PaymentView extends AbstractView {

    private static final String PAYMENT_INPUT_MESSAGE = "[결제할 주문 번호와 결제 방법을 순서대로 입력하세요]";
    private static final String PAYMENT_SUCCESS_MESSAGE = "[결제 완료]";
    private static final String PAYMENT_TYPE = "결제 방법";

    private PaymentService paymentService = AppConfig.getPaymentService();

    public PaymentView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        pay();
    }

    private void pay() {
        while (true) {
            showMessage();
            try {
                Long orderId = scanner.nextLong();
                String paymentTypeName = scanner.next();
                paymentService.makePayment(orderId, PaymentType.getPaymentTypeByName(paymentTypeName));
                System.out.println(PAYMENT_SUCCESS_MESSAGE);
                break;
            } catch (OrderNotFoundException | PaymentTypeNotFoundException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            } catch (OrderAlreadyCanceledException | NotEnoughMoneyException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
                break;
            }
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
