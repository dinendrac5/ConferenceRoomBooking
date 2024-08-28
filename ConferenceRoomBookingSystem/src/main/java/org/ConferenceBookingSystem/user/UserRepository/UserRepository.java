package org.ConferenceBookingSystem.user.UserRepository;

import org.ConferenceBookingSystem.user.UserModel.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private final List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return this.userList;
    }

    @Override
    public User findById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i <= userList.size(); i++) {
            if (userList.get(i).getId() == user.getId()) {
                userList.set(i, user);
            }
        }
    }

    @Override
    public void removeUser(User user) {
        userList.removeIf(userFromList -> user.getId() == userFromList.getId());
    }

}
