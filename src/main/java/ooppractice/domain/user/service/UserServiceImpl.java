package ooppractice.domain.user.service;

import lombok.RequiredArgsConstructor;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.exception.InvalidAmountException;
import ooppractice.domain.user.exception.UserNotFoundException;
import ooppractice.domain.user.exception.WrongPasswordException;
import ooppractice.domain.user.repository.UserRepository;
import ooppractice.global.exception.ErrorCode;
import ooppractice.global.util.Constant;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        User foundUser = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        if (!foundUser.getPassword().equals(password)) {
            throw new WrongPasswordException(ErrorCode.WRONG_PASSWORD);
        }
        return foundUser;
    }

    @Override
    public User getUserById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        return foundUser;
    }

    @Override
    public void makeDeposit(Long id, int amount) {
        if (amount <= Constant.LOWER_LIMIT_OF_DEPOSIT_AMOUNT) {
            throw new InvalidAmountException(ErrorCode.INVALID_AMOUNT);
        }
        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        int afterCalculateBenefit = foundUser.getUserGrade().calculateBenefit(amount);
        foundUser.deposit(afterCalculateBenefit);
    }
}
