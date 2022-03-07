package ooppractice.view.order;

import ooppractice.domain.order.domain.Order;
import ooppractice.domain.order.exception.OrderNotFoundException;
import ooppractice.domain.order.service.OrderService;
import ooppractice.domain.orderitem.domain.OrderItem;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.global.util.UserIdStorage;

import java.util.List;
import java.util.Scanner;

import static ooppractice.global.util.Constant.*;

public class OrderInfoView extends AbstractView {

    private static final String ORDER_NUMBER = "주문 번호";
    private static final String ORDER_STATUS = "주문 상태";
    private static final String ORDER_DATE = "주문 일자";
    private static final String ITEM_NAME = "상품 이름";
    private static final String ORDER_QUANTITY = "주문 수량";
    private static final String ORDER_PRICE = "주문 금액";

    private final OrderService orderService;

    public OrderInfoView(Scanner scanner, OrderService orderService) {
        super(scanner);
        this.orderService = orderService;
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
                        .append(ORDER_PRICE).append(SEMICOLON).append(BLANK).append(order.getTotalPrice()).append(WON).append(NEXT_LINE)
                        .append(BOUNDARY).append(NEXT_LINE);
            });
            System.out.println(sb);
            clearSb();
        } catch (OrderNotFoundException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(ErrorCode.LOGIN_USER_NOT_FOUND);
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
