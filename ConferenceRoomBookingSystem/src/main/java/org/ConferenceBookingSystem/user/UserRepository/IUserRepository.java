package org.ConferenceBookingSystem.user.UserRepository;

import org.ConferenceBookingSystem.user.UserModel.User;

import java.util.List;

public interface IUserRepository {
    User findById(int Id);

    List<User> findAll();
}
