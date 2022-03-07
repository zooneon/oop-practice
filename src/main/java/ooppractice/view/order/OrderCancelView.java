package ooppractice.view.order;

import ooppractice.domain.order.exception.OrderAlreadyCanceledException;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.order.exception.PaymentNotCanceledException;
import ooppractice.domain.order.service.OrderService;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.exception.ErrorResponse;

import java.util.Scanner;

public class OrderCancelView extends AbstractView {

    private static final String ORDER_CANCEL_INPUT_MESSAGE = "[취소할 주문의 번호를 입력해주세요]";
    private static final String ORDER_CANCEL_SUCCESS_MESSAGE = "[주문 취소 완료]";

    private final OrderService orderService;

    public OrderCancelView(Scanner scanner, OrderService orderService) {
        super(scanner);
        this.orderService = orderService;
    }

    @Override
    public void start() {
        cancel();
    }

    private void cancel() {
        showMessage();
        try {
            Long orderId = scanner.nextLong();
            orderService.cancelOrder(orderId);
            System.out.println(ORDER_CANCEL_SUCCESS_MESSAGE);
        } catch (OrderNotFoundException | PaymentNotCanceledException | OrderAlreadyCanceledException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        }
    }

    @Override
    protected void selectOption() {
    }

    @Override
    protected void showMessage() {
        System.out.println(ORDER_CANCEL_INPUT_MESSAGE);
    }
}
