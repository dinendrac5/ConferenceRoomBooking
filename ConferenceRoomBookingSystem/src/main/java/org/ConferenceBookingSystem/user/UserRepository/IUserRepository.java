package org.ConferenceBookingSystem.user.UserRepository;

import org.ConferenceBookingSystem.user.UserModel.User;

import java.util.List;

public interface IUserRepository {
    User findById(int Id);

    List<User> findAll();

    void addUser(User user);

    void removeUser(User user);

}
