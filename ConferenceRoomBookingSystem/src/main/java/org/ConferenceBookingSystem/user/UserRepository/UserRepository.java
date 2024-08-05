package org.ConferenceBookingSystem.user.UserRepository;

import org.ConferenceBookingSystem.user.UserModel.User;

import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public User findById(int Id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }
}
