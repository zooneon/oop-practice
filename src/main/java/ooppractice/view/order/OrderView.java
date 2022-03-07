package ooppractice.view;

import ooppractice.domain.item.exception.ItemNotFoundException;
import ooppractice.domain.order.service.OrderService;
import ooppractice.domain.orderitem.exception.OutOfStockException;
import ooppractice.domain.orderitem.exception.SoldOutException;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.global.util.UserIdStorage;

import java.util.Scanner;

public class OrderView extends AbstractView {

    private static final String ORDER_INPUT_MESSAGE = "[주문할 상품의 이름과 수량을 순서대로 입력하세요]";
    private static final String ORDER_SUCCESS_MESSAGE = "[주문 완료]";

    private OrderService orderService = AppConfig.getOrderService();

    public OrderView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        order();
    }

    private void order() {
        while (true) {
            showMessage();
            try {
                String itemName = scanner.next();
                int quantity = scanner.nextInt();
                Long userId = UserIdStorage.getId();
                orderService.makeOrder(userId, itemName, quantity);
                System.out.println(ORDER_SUCCESS_MESSAGE);
                break;
            } catch (UserNotFoundException | SoldOutException | OutOfStockException | ItemNotFoundException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            }
        }
    }

    @Override
    protected void showMessage() {
        System.out.println(ORDER_INPUT_MESSAGE);
    }
}
