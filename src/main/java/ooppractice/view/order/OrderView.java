package ooppractice.view.order;

import ooppractice.domain.item.exception.ItemNotFoundException;
import ooppractice.domain.order.service.OrderService;
import ooppractice.domain.orderitem.exception.OutOfStockException;
import ooppractice.domain.orderitem.exception.SoldOutException;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.global.util.UserIdStorage;

import java.util.Scanner;

public class OrderView extends AbstractView {

    private static final String ORDER_INPUT_MESSAGE = "[주문할 상품의 이름과 수량을 순서대로 입력하세요]";
    private static final String ORDER_SUCCESS_MESSAGE = "[주문 완료]";

    private final OrderService orderService;

    public OrderView(Scanner scanner, OrderService orderService) {
        super(scanner);
        this.orderService = orderService;
    }

    @Override
    public void start() {
        order();
    }

    @Override
    protected void selectOption() {
    }

    private void order() {
        showMessage();
        try {
            String itemName = scanner.next();
            int quantity = scanner.nextInt();
            Long userId = UserIdStorage.getId();
            orderService.makeOrder(userId, itemName, quantity);
            System.out.println(ORDER_SUCCESS_MESSAGE);
        } catch (ItemNotFoundException | SoldOutException | OutOfStockException e) {
            System.out.println(ErrorResponse.of(e.getErrorCode()));
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(ErrorCode.LOGIN_USER_NOT_FOUND);
        }
    }

    @Override
    protected void showMessage() {
        System.out.println(ORDER_INPUT_MESSAGE);
    }
}
