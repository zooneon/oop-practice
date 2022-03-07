package ooppractice.view.mypage;

import ooppractice.domain.user.exception.InvalidAmountException;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.service.UserService;
import ooppractice.global.common.view.AbstractView;
import ooppractice.global.config.AppConfig;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.exception.ErrorResponse;
import ooppractice.global.util.UserIdStorage;

import java.util.Scanner;

public class DepositView extends AbstractView {

    private static final String DEPOSIT_INPUT_MESSAGE = "[입금할 금액을 원단위로 입력하세요]";
    private static final String DEPOSIT_SUCCESS_MESSAGE = "[입금 완료]";

    private UserService userService = AppConfig.getUserService();

    public DepositView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start() {
        deposit();
    }

    @Override
    protected void selectOption() {
    }

    private void deposit() {
        while (true) {
            showMessage();
            try {
                int amount = scanner.nextInt();
                Long userId = UserIdStorage.getId();
                userService.makeDeposit(userId, amount);
                System.out.println(DEPOSIT_SUCCESS_MESSAGE);
                break;
            } catch (InvalidAmountException e) {
                System.out.println(ErrorResponse.of(e.getErrorCode()));
            } catch (UserNotFoundException e) {
                throw new UserNotFoundException(ErrorCode.LOGIN_USER_NOT_FOUND);
            }
        }
    }

    @Override
    protected void showMessage() {
        System.out.println(DEPOSIT_INPUT_MESSAGE);
    }
}
