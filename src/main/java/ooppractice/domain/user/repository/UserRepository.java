package ooppractice.domain.user.repository;

import ooppractice.domain.user.domain.User;
import ooppractice.global.common.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByUsername(String username) {
        List<User> userList = findAll();
        Optional<User> userOptional = userList.stream().filter(user -> user.getUsername().equals(username)).findFirst();
        return userOptional;
    }
}
