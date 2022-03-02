package ooppractice.domain.user.service;

import ooppractice.domain.user.domain.User;

public interface UserService {

    User login(String username, String password);

    User getUserById(Long id);

    void makeDeposit(Long id, int amount);
}
