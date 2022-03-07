package ooppractice.view;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.exception.OrderAlreadyCanceledException;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.order.exception.PaymentNotCanceledException;
import ooppractice.domain.order.service.OrderService;
import ooppractice.domain.orderitem.domain.OrderItem;
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

public class OrderInfoView extends AbstractView {

    private static final String ORDER_CANCEL_INPUT_MESSAGE = "[취소하고자 하는 주문 번호를 입력하세요]";
    private static final String CANCEL_COMPLETE = "[취소 완료]";
    private static final String ORDER_INFO = "주문 정보";
    private static final String CANCEL_ORDER = "주문 취소";
    private static final String ORDER_NUMBER = "주문 번호";
    private static final String ORDER_STATUS = "주문 상태";
    private static final String ORDER_DATE = "주문 일자";
    private static final String ITEM_NAME = "상품 이름";
    private static final String ORDER_QUANTITY = "주문 수량";
    private static final String ORDER_PRICE = "주문 금액";

    private OrderService orderService = AppConfig.getOrderService();

    public OrderInfoView(Scanner scanner) {
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
                    showOrderInfo();
                } else if (userInput == OPTION_TWO) {
                    cancelOrder();
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

    private void cancelOrder() {
        while (true) {
            System.out.println(ORDER_CANCEL_INPUT_MESSAGE);
            try {
                Long orderId = scanner.nextLong();
                orderService.cancelOrder(orderId);
                System.out.println(CANCEL_COMPLETE);
                break;
            } catch (OrderAlreadyCanceledException | PaymentNotCanceledException | OrderNotFoundException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            }
        }
    }

    @Override
    protected void showMessage() {
        sb.append(MENU_INPUT_MESSAGE).append(NEXT_LINE)
                .append(OPTION_ONE).append(DOT).append(BLANK).append(ORDER_INFO)
                .append(OPTION_TWO).append(DOT).append(BLANK).append(CANCEL_ORDER)
                .append(OPTION_THREE).append(DOT).append(BLANK).append(QUIT);
        System.out.println(sb);
        clearSb();
    }

    private void showOrderInfo() {
        Long userId = UserIdStorage.getId();
        printOrderInfo(userId);
    }

    private void printOrderInfo(Long userId) {
        try {
            List<Order> orderList = orderService.getOrderList(userId);
            orderList.forEach(order -> {
                sb.append(ORDER_NUMBER).append(SEMICOLON).append(BLANK).append(order.getId()).append(NEXT_LINE)
                        .append(ORDER_STATUS).append(SEMICOLON).append(BLANK).append(order.getOrderStatus().getMessage()).append(NEXT_LINE)
                        .append(ORDER_DATE).append(SEMICOLON).append(BLANK).append(order.getOrderDate()).append(NEXT_LINE)
                        .append(getOrderItemsInfo(order.getOrderItemList())).append(NEXT_LINE)
                        .append(ORDER_PRICE).append(SEMICOLON).append(BLANK).append(order.getTotalPrice()).append(WON);
                System.out.println(sb);
                clearSb();
            });
        } catch (UserNotFoundException | OrderNotFoundException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        }
    }

    private String getOrderItemsInfo(List<OrderItem> orderItemList) {
        StringBuilder orderItemSb = new StringBuilder();
        orderItemList.forEach(orderItem -> {
            orderItemSb.append(ITEM_NAME).append(SEMICOLON).append(BLANK).append(orderItem.getItem().getItemName()).append(NEXT_LINE)
                    .append(ORDER_QUANTITY).append(SEMICOLON).append(BLANK).append(orderItem.getOrderQuantity());
        });
        String orderItemInfo = orderItemSb.toString();
        orderItemSb.delete(SB_START_INDEX, orderItemSb.length());
        return orderItemInfo;
    }
}
