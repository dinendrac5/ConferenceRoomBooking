package org.ConferenceBookingSystem.user.UserRepository;

import org.ConferenceBookingSystem.user.UserModel.User;

import java.util.List;

public interface IUserRepository {

    User findById(int Id);

    List<User> findAll();

    //add, remove and update user methods should be added
    void addUser(User user);

    void updateUser(User user);

    void removeUser(User user);
}
