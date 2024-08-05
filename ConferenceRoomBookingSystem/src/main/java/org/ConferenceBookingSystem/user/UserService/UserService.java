package org.ConferenceBookingSystem.user.UserService;

import org.ConferenceBookingSystem.user.UserModel.User;

public interface UserService {

    void createUser(User user);

    void updateUser(User user);

    void deleteuser(User user);
}
